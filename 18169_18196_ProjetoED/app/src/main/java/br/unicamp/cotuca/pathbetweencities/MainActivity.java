package br.unicamp.cotuca.pathbetweencities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import br.unicamp.cotuca.pathbetweencities.Grafo.Grafo;
import br.unicamp.cotuca.pathbetweencities.caminho.Caminho;
import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;
import br.unicamp.cotuca.pathbetweencities.hash.BucketHashCidade;
import br.unicamp.cotuca.pathbetweencities.lista.ListaSimples;
import br.unicamp.cotuca.pathbetweencities.lista.NoLista;
import br.unicamp.cotuca.pathbetweencities.pilha.PilhaLista;

public class MainActivity extends AppCompatActivity {

    public static final int PERMISSION_EXTERNAL_STORAGE = 1;
    int qtasCidades = 0, qtosCaminhos = 0;
    CidadeView canvaImagem;
    Button btnBuscar, btnAddCidade, btnAddCaminho;
    Spinner spOrigem, spDestino;
    EditText edtResultados;

    BucketHashCidade hashCidades = new BucketHashCidade();
    ArrayList<Cidade>[] arrayCidadesHash = hashCidades.getData();
    ListaSimples<Cidade> listaCidades;
    ListaSimples<Caminho> listaCaminhos;
    Caminho[][] matAdjacencias;
    PilhaLista<PilhaLista<Caminho>> caminhosDescobertos;
    File cidades, caminhos, sdcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvaImagem = findViewById(R.id.canvaImagem);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnAddCaminho = findViewById(R.id.btnAddCaminho);
        btnAddCidade = findViewById(R.id.btnAddCidade);
        spOrigem = findViewById(R.id.spOrigem);
        spDestino = findViewById(R.id.spDestino);
        edtResultados = findViewById(R.id.edtResultados);
        edtResultados.setEnabled(false);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSION_EXTERNAL_STORAGE);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PERMISSION_EXTERNAL_STORAGE);
        listaCidades = new ListaSimples<>();
        sdcard = Environment.getExternalStorageDirectory();
        cidades = new File(sdcard.getPath() + "/Download/Cidades.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(cidades));
            String receiveString = "";

            while ((receiveString = bufferedReader.readLine()) != null ) {
                stringBuilder.append(receiveString);
                Cidade c = new Cidade(receiveString);
                listaCidades.InserirAposFim(c);
                hashCidades.insert(c);
                qtasCidades++;
            }
            criarGrafo();
            Object arrayCidadesObject[] = listaCidades.toArray();
            Cidade[] arrayCidades = new Cidade[arrayCidadesObject.length];
            for(int i = 0; i < arrayCidadesObject.length; i++)
                arrayCidades[i] = (Cidade)arrayCidadesObject[i];

            desenharPontos(arrayCidades);

            String arrayNomeCidades[] = new String[arrayCidades.length];
            for(int i = 0; i < arrayCidadesObject.length; i++)
                arrayNomeCidades[i] = arrayCidades[i].getNomeCidade();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, arrayNomeCidades);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spOrigem.setAdapter(adapter);
            spDestino.setAdapter(adapter);
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não encontrado", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não pode ser lido", Toast.LENGTH_SHORT).show();
        }

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarCaminhosDijkstra(spOrigem.getSelectedItemPosition(), spDestino.getSelectedItemPosition());
                buscarCaminhosBackingTrack(spOrigem.getSelectedItemPosition(), spDestino.getSelectedItemPosition());
            }
        });

        btnAddCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdicionarCidadeActivity.class);
                intent.putExtra("listaCidades", listaCidades);
                intent.putExtra("qtosDados",qtasCidades);
                startActivityForResult(intent,1);
            }
        });

        btnAddCaminho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(MainActivity.this, AdicionarCaminhoActivity.class);
                intent.putExtra("listaCaminhos", listaCaminhos);
                intent.putExtra("listaCidades", listaCidades);
                startActivityForResult(intent,2);*/
                salvarArquivos();
            }
        });
    }

    private void salvarArquivos(){
        try {
            FileOutputStream outCaminhos = new FileOutputStream(caminhos, false);
            String escrever = "";
            for(NoLista<Caminho> atual = listaCaminhos.getPrimeiro(); atual.getProx() != null; atual = atual.getProx()) {
                Caminho c = atual.getInfo();
                escrever = String.format("%015s",c.getNomeCidadeOrigem()) +
                        String.format("%016s",c.getNomeCidadeDestino()) + String.format("%005s", c.getDistancia()) + c.getTempo();

            }
        }
        catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não encontrado", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não pode ser lido", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                listaCidades = (ListaSimples<Cidade>) data.getSerializableExtra("listaCidades");
                qtasCidades = (int) data.getSerializableExtra("qtosDados");
                hashCidades.insert(listaCidades.getUltimo().getInfo());
                qtasCidades++;
                Object[] objs = listaCidades.toArray();
                String[] arrayNomeCidades = new String[listaCidades.getQuantosNos()];
                for(int i = 0; i < arrayNomeCidades.length; i++)
                    arrayNomeCidades[i] = ((Cidade) objs[i]).getNomeCidade();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, arrayNomeCidades);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spOrigem.setAdapter(adapter);
                spDestino.setAdapter(adapter);
                recriarGrafo();
            }
        }
        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                listaCaminhos = (ListaSimples<Caminho>) data.getSerializableExtra("listaCaminhos");
                qtosCaminhos++;
                Caminho c = listaCaminhos.getUltimo().getInfo();
                Cidade cAuxOrigem = hashCidades.procurarCidade(c.getNomeCidadeOrigem());
                Cidade cAuxDestino = hashCidades.procurarCidade(c.getNomeCidadeDestino());
                matAdjacencias[cAuxOrigem.getIdCidade()][cAuxDestino.getIdCidade()] = c;
            }
        }
    }

    public void recriarGrafo(){
        matAdjacencias = new Caminho[qtasCidades][qtasCidades];
        for(NoLista<Caminho> atual = listaCaminhos.getPrimeiro(); atual.getProx() != null; atual = atual.getProx()) {
            Caminho c = atual.getInfo();
            Cidade cAuxOrigem = hashCidades.procurarCidade(c.getNomeCidadeOrigem());
            Cidade cAuxDestino = hashCidades.procurarCidade(c.getNomeCidadeDestino());
            matAdjacencias[cAuxOrigem.getIdCidade()][cAuxDestino.getIdCidade()] = c;
        }
    }

    public void criarGrafo() {
        matAdjacencias = new Caminho[qtasCidades][qtasCidades];
        caminhos = new File(sdcard.getPath() + "/Download/GrafoTremEspanhaPortugal.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(caminhos));
            String receiveString = "";

            listaCaminhos = new ListaSimples<>();
            while ((receiveString = bufferedReader.readLine()) != null ) {
                stringBuilder.append(receiveString);
                Caminho c = new Caminho(receiveString);
                Cidade cAuxOrigem = hashCidades.procurarCidade(c.getNomeCidadeOrigem());
                Cidade cAuxDestino = hashCidades.procurarCidade(c.getNomeCidadeDestino());
                matAdjacencias[cAuxOrigem.getIdCidade()][cAuxDestino.getIdCidade()] = c;
                listaCaminhos.InserirAposFim(c);
                qtosCaminhos++;
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não encontrado", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não pode ser lido", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscarCaminhosDijkstra(int cdOrigem, int cdDestino){

        Grafo grafo = new Grafo(qtasCidades);
        Object[] arrayObjs = listaCidades.toArray();
        Cidade[] arrayCidades = new Cidade[listaCidades.getQuantosNos()];
        Object[] arrayObjsCaminho = listaCaminhos.toArray();
        Caminho[] arrayCaminhos = new Caminho[listaCaminhos.getQuantosNos()];
        for(int i = 0; i < arrayObjsCaminho.length; i++)
            arrayCaminhos[i] = (Caminho)arrayObjsCaminho[i];
        for(int i = 0; i < arrayObjs.length; i++)
            arrayCidades[i] = (Cidade)arrayObjs[i];
        for(int i = 0; i < qtasCidades; i++)
            grafo.novoVertice(arrayCidades[i]);
        for(int i = 0; i < qtosCaminhos; i++)
        {
            Caminho c = arrayCaminhos[i];
            Cidade cAuxOrigem = hashCidades.procurarCidade(c.getNomeCidadeOrigem());
            Cidade cAuxDestino = hashCidades.procurarCidade(c.getNomeCidadeDestino());
            grafo.novaAresta(cAuxOrigem.getIdCidade(), cAuxDestino.getIdCidade(), c);
        }
        edtResultados.setText(grafo.acharCaminho(cdOrigem, cdDestino, edtResultados));
    }

    public void buscarCaminhosBackingTrack(int cdOrigem, int cdDestino) {
        if (cdOrigem != cdDestino) {
            boolean achouTodos = false;
            boolean[] passouCidade = new boolean[qtasCidades + 1];
            int c = 0;
            PilhaLista<Caminho> caminhos = new PilhaLista();
            caminhosDescobertos = new PilhaLista();

            for (int i = 0; i < qtasCidades; i++)
                passouCidade[i] = false;
            do {
                if (cdOrigem == cdDestino || c >= qtasCidades) {
                    if (caminhos.estaVazia())
                        achouTodos = true;
                    else {
                        try{
                            if (cdOrigem == cdDestino)
                                caminhosDescobertos.empilhar(caminhos.copia());
                            Caminho caminho = caminhos.desempilhar();
                            Cidade cAuxOrigem = hashCidades.procurarCidade(caminho.getNomeCidadeOrigem());
                            Cidade cAuxDestino = hashCidades.procurarCidade(caminho.getNomeCidadeDestino());
                            cdOrigem = cAuxOrigem.getIdCidade();
                            passouCidade[cAuxDestino.getIdCidade()] = false;
                            if (cAuxDestino.getIdCidade() != cdOrigem)
                                c = cAuxDestino.getIdCidade() + 1;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                if (c < qtasCidades && matAdjacencias[cdOrigem][c] != null) {
                    if (passouCidade[c] != true) {
                        passouCidade[cdOrigem] = true;
                        caminhos.empilhar(matAdjacencias[cdOrigem][c]);
                        cdOrigem = c;
                        c = -1;
                    }
                }
                c++;
            }
            while (!achouTodos);
            exibirCaminhos(caminhosDescobertos);
        }
        else
        if (cdOrigem != -1 && cdDestino != -1)
            Toast.makeText(getApplicationContext(), "Você já está na cidade !", Toast.LENGTH_SHORT).show();


    }

    public void exibirCaminhos(PilhaLista<PilhaLista<Caminho>> caminhos) {
        PilhaLista<PilhaLista<Caminho>> pilhaCopia = caminhos.copia();

        while(!caminhos.estaVazia()){
            try{
                PilhaLista<Caminho> pcAtual = caminhos.desempilhar();
                PilhaLista<Caminho> aux = new PilhaLista();

                while (!pcAtual.estaVazia())
                    aux.empilhar(pcAtual.desempilhar());

                Caminho cAtual = null;
                ListaSimples<Cidade> cidadesPrintar = new ListaSimples<>();
                while (!aux.estaVazia())
                {
                    cAtual = aux.desempilhar();
                    int indiceO = hashCidades.hash(cAtual.getNomeCidadeOrigem());
                    int indiceD = hashCidades.hash(cAtual.getNomeCidadeDestino());
                    cidadesPrintar.InserirAposFim(arrayCidadesHash[indiceO].get(0));
                    cidadesPrintar.InserirAposFim(arrayCidadesHash[indiceD].get(0));
                }
                Object[] o = cidadesPrintar.toArray();
                Cidade[] cidadesAPrintar = new Cidade[o.length];
                for(int indiceObj = 0; indiceObj < o.length; indiceObj++)
                    cidadesAPrintar[indiceObj] = (Cidade)o[indiceObj];
                desenharLinhas(cidadesAPrintar);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        caminhosDescobertos = pilhaCopia;
    }

    public void desenharPontos(Cidade[] cidades) {
        Bitmap bmp = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        Canvas ponto = new Canvas(bmp);
        canvaImagem.setePonto(true);
        canvaImagem.setCidades(cidades);
        canvaImagem.draw(ponto);
    }

    public void desenharLinhas(Cidade[] cidades){
        Canvas linha = new Canvas();
        canvaImagem.setePonto(false);
        canvaImagem.setCidades(cidades);
        canvaImagem.draw(linha);
    }
}
