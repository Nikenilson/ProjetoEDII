package br.unicamp.cotuca.pathbetweencities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
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
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import br.unicamp.cotuca.pathbetweencities.caminho.Caminho;
import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;
import br.unicamp.cotuca.pathbetweencities.hash.BucketHashCidade;
import br.unicamp.cotuca.pathbetweencities.lista.ListaSimples;
import br.unicamp.cotuca.pathbetweencities.pilha.PilhaLista;

public class MainActivity extends AppCompatActivity {

    Button btnBuscar, btnAddCidade, btnAddCaminho;
    Spinner spOrigem, spDestino;
    EditText edtResultados;
    public static final int PERMISSION_EXTERNAL_STORAGE = 1;
    BucketHashCidade hashCidades = new BucketHashCidade();
    ArrayList<Cidade>[] arrayCidades = hashCidades.getData();
    int qtosDados = 0, corAtual;
    //Arvore<Cidade> arvore;
    Caminho[][] matAdjacencias;
    PilhaLista<PilhaLista<Caminho>> caminhosDescobertos;
    PilhaLista<Caminho> caminhoADesenhar, melhorCaminho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscar = findViewById(R.id.btnBuscar);
        btnAddCaminho = findViewById(R.id.btnAddCaminho);
        btnAddCidade = findViewById(R.id.btnAddCidade);
        spOrigem = findViewById(R.id.spOrigem);
        spDestino = findViewById(R.id.spDestino);
        edtResultados = findViewById(R.id.edtResultados);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSION_EXTERNAL_STORAGE);
        ListaSimples<Cidade> listaCidades = new ListaSimples<>();
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard.getPath() + "/Download/Cidades.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String receiveString = "";

            while ((receiveString = bufferedReader.readLine()) != null ) {
                stringBuilder.append(receiveString);
                Cidade c = new Cidade(receiveString);
                listaCidades.InserirAposFim(c);
                hashCidades.insert(c);
                qtosDados++;
            }
            criarGrafo();
            Object arrayCidadesObject[] = listaCidades.toArray();
            Cidade[] arrayCidades = new Cidade[arrayCidadesObject.length];
            for(int i = 0; i < arrayCidadesObject.length; i++)
                arrayCidades[i] = (Cidade)arrayCidadesObject[i];

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
                buscarCaminhos(spOrigem.getSelectedItemPosition(), spDestino.getSelectedItemPosition());
            }
        });

        btnAddCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this, );
            }
        });
    }

    public void criarGrafo()
    {
        matAdjacencias = new Caminho[qtosDados][qtosDados];
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard.getPath() + "/Download/GrafoTremEspanhaPortugal.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String receiveString = "";

            while ((receiveString = bufferedReader.readLine()) != null ) {
                stringBuilder.append(receiveString);
                Caminho c = new Caminho(receiveString);
                Cidade cAuxOrigem = hashCidades.procurarCidade(c.getNomeCidadeOrigem());
                Cidade cAuxDestino = hashCidades.procurarCidade(c.getNomeCidadeDestino());
                matAdjacencias[cAuxOrigem.getIdCidade()][cAuxDestino.getIdCidade()] = c;
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não encontrado", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não pode ser lido", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscarCaminhos(int cdOrigem, int cdDestino)
    {
        if (cdOrigem != cdDestino)
        {
            boolean achouTodos = false;
            boolean[] passouCidade = new boolean[qtosDados + 1];
            int c = 0;
            PilhaLista<Caminho> caminhos = new PilhaLista();
            caminhosDescobertos = new PilhaLista();

            for (int i = 0; i < qtosDados; i++)
                passouCidade[i] = false;
            do
            {
                if (cdOrigem == cdDestino || c >= qtosDados)
                {
                    if (caminhos.estaVazia())
                        achouTodos = true;
                    else
                    {
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
                if (c < qtosDados && matAdjacencias[cdOrigem][c] != null)
                {
                    if (passouCidade[c] != true)
                    {
                        passouCidade[cdOrigem] = true;
                        caminhos.empilhar(matAdjacencias[cdOrigem][c]);
                        cdOrigem = c;
                        c = -1; // recebe -1, pois incrementa logo após
                    }
                }
                c++;
            }
            while (!achouTodos);
            exibirCaminhos(caminhosDescobertos);
            /*if (!caminhosDescobertos.EstaVazia())
                AcharMelhorCaminho(caminhosDescobertos);*/
        }
        /*else
        if (cdOrigem != -1 && cdDestino != -1)
            MessageBox.Show("Você já está na cidade!");*/

    }

    public void exibirCaminhos(PilhaLista<PilhaLista<Caminho>> caminhos)
    {
        PilhaLista<PilhaLista<Caminho>> pilhaCopia = caminhos.copia();

        while(!caminhos.estaVazia()){
            try{
                PilhaLista<Caminho> pcAtual = caminhos.desempilhar();
                PilhaLista<Caminho> aux = new PilhaLista();

                while (!pcAtual.estaVazia())
                    aux.empilhar(pcAtual.desempilhar());

                Caminho cAtual = null;
                int i = 1;
                edtResultados.append("Caminho Nº " + i);
                while (!aux.estaVazia())
                {
                    cAtual = aux.desempilhar();
                    int indiceO = hashCidades.hash(cAtual.getNomeCidadeOrigem());
                    int indiceD = hashCidades.hash(cAtual.getNomeCidadeDestino());
                    edtResultados.append(arrayCidades[indiceO].get(0).getNomeCidade() + " -> " + arrayCidades[indiceD].get(0).getNomeCidade());
                }
                edtResultados.append("\n");
                i++;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        caminhosDescobertos = pilhaCopia;
    }
}
