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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
    ListaSimples<Cidade>[] arrayCidadesHash = hashCidades.getData();
    ListaSimples<Cidade> listaCidades;
    ListaSimples<Caminho> listaCaminhos;
    Caminho[][] matAdjacencias;
    PilhaLista<PilhaLista<Caminho>> caminhosDescobertos;
    Grafo grafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linka cada objeto ao seu respectivo controle no xml
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
        try{
            //Se o arquivo nao existe, cria o arquivo
            File file = new File(getFilesDir().getPath() + "/cidades.txt");
            OutputStreamWriter osw;
            if(!file.exists()){
                FileOutputStream fOutC = openFileOutput("cidades.txt", MODE_PRIVATE);
                osw = new OutputStreamWriter(fOutC);
                osw.write(" 0Covilhã         0.252 0.479\n" +
                        " 1A Coruna        0.195 0.151\n" +
                        " 2Albacete        0.609 0.609\n" +
                        " 3Alicante        0.697 0.675\n" +
                        " 4Barcelona       0.864 0.363\n" +
                        " 5Bilbao          0.542 0.164\n" +
                        " 6Braga           0.194 0.344\n" +
                        " 7Burgos          0.494 0.261\n" +
                        " 8Caceres         0.324 0.561\n" +
                        " 9Cadiz           0.327 0.854\n" +
                        "10Cartagena       0.666 0.751\n" +
                        "11Castelo Branco  0.252 0.524\n" +
                        "12Coimbra         0.193 0.485\n" +
                        "13Cordoba         0.425 0.721\n" +
                        "14El Ejido        0.550 0.832\n" +
                        "15Gijon           0.369 0.131\n" +
                        "16Girona          0.907 0.299\n" +
                        "17Granada         0.498 0.791\n" +
                        "18Guadalajara     0.527 0.443\n" +
                        "19Guarda          0.266 0.452\n" +
                        "20Huelva          0.287 0.784\n" +
                        "21Jaen            0.488 0.734\n" +
                        "22Leon            0.375 0.235\n" +
                        "23Lisboa          0.148 0.638\n" +
                        "24Lleida          0.768 0.339\n" +
                        "25Logrono         0.572 0.249\n" +
                        "26Lorca           0.619 0.742\n" +
                        "27Loule           0.218 0.796\n" +
                        "28Lugo            0.248 0.192\n" +
                        "29Madrid          0.492 0.462\n" +
                        "30Malaga          0.446 0.837\n" +
                        "31Mataro          0.882 0.350\n" +
                        "32Montpellier     0.976 0.126\n" +
                        "33Murcia          0.655 0.710\n" +
                        "34Ourense         0.229 0.261\n" +
                        "35Oviedo          0.356 0.152\n" +
                        "36Pau             0.703 0.159\n" +
                        "37Perpignan       0.911 0.223\n" +
                        "38Pombal          0.179 0.517\n" +
                        "39Ponferrada      0.310 0.240\n" +
                        "40Porto           0.180 0.388\n" +
                        "41Salamanca       0.368 0.407\n" +
                        "42San Sebastian   0.601 0.156\n" +
                        "43Santander       0.487 0.141\n" +
                        "44Santiago de C.  0.185 0.206\n" +
                        "45Sevilha         0.347 0.770\n" +
                        "46Tarragona       0.806 0.391\n" +
                        "47Toledo          0.471 0.521\n" +
                        "48Toulouse        0.817 0.126\n" +
                        "49Valencia        0.702 0.561\n" +
                        "50Valladolid      0.425 0.334\n" +
                        "51Vigo            0.174 0.272\n" +
                        "52Viseu           0.225 0.439\n" +
                        "53Zaragoza        0.672 0.334");
                osw.flush();
                osw.close();
            }
            File file2 = new File(getFilesDir().getPath() + "/caminhos.txt");
            //Se o outro aqrquivo nao existe, cria o outro arquivo
            if(!file2.exists()){
                FileOutputStream fOut = openFileOutput("caminhos.txt", MODE_PRIVATE);
                osw = new OutputStreamWriter(fOut);
                osw.write("Madrid         Salamanca       220  150\n" +
                        "Salamanca      Guarda          160   90\n" +
                        "Guarda         Viseu            76   80\n" +
                        "Madrid         Albacete        257  280\n" +
                        "Madrid         Toledo           72  205\n" +
                        "Madrid         Valladolid      189  140\n" +
                        "Toledo         Cordoba         344  210\n" +
                        "Cordoba        Sevilha         140  220\n" +
                        "Sevilha        Huelva           94  201\n" +
                        "Sevilha        Cadiz           121   80\n" +
                        "Sevilha        Caceres         267  120\n" +
                        "Caceres        Toledo          260  110\n" +
                        "Caceres        Castelo Branco  141   90\n" +
                        "Pombal         Castelo Branco  137  150\n" +
                        "Zaragoza       Lleida          150  210\n" +
                        "Lleida         Tarragona       100  205\n" +
                        "Tarragona      Barcelona        99  208\n" +
                        "Tarragona      Valencia        258  250\n" +
                        "Valencia       Albacete        188  270\n" +
                        "Albacete       Murcia          144  230\n" +
                        "Murcia         Cartagena        50  201\n" +
                        "Valencia       Alicante        179  105\n" +
                        "Alicante       Murcia           82   80\n" +
                        "Murcia         Lorca            70   60\n" +
                        "Zaragoza       Valencia        308   93\n" +
                        "Zaragoza       Pau             235   60\n" +
                        "Pau            Toulouse        195   90\n" +
                        "Toulouse       Montpellier     246   76\n" +
                        "Zaragoza       Logrono         170  100\n" +
                        "Logrono        San Sebastian   167   75\n" +
                        "Logrono        Bilbao          136   77\n" +
                        "Logrono        Burgos          104   50\n" +
                        "Bilbao         Burgos          158   70\n" +
                        "Burgos         Valladolid      136   50\n" +
                        "Valladolid     Santander       244   66\n" +
                        "Valladolid     Leon            137   95\n" +
                        "Leon           Oviedo          125   83\n" +
                        "Leon           Ponferrada      113   75\n" +
                        "Oviedo         Gijon            30   73\n" +
                        "Loule          Lisboa          265   75\n" +
                        "Lisboa         Pombal          140   70\n" +
                        "Pombal         Coimbra          36   96\n" +
                        "Coimbra        Viseu            92   78\n" +
                        "Coimbra        Porto           107  107\n" +
                        "Porto          Braga            46   42\n" +
                        "Braga          Vigo             81   18\n" +
                        "Vigo           Ourense          71   42\n" +
                        "Ourense        Ponferrada      100   48\n" +
                        "Vigo           Santiago de C.   72   48\n" +
                        "Santiago de C. A Coruna         64   67\n" +
                        "Santiago de C. Ourense          82  136\n" +
                        "A Coruna       Lugo             80   47\n" +
                        "Lugo           Ponferrada       93   71\n" +
                        "Cordoba        Jaen            120   73\n" +
                        "Cordoba        Malaga          168  203\n" +
                        "Malaga         Granada          88   50\n" +
                        "Jaen           Granada          67   53\n" +
                        "Granada        El Ejido        113   37\n" +
                        "Madrid         Guadalajara      68   45\n" +
                        "Guadalajara    Zaragoza        257   72\n" +
                        "Barcelona      Mataro           31   31\n" +
                        "Mataro         Girona           80   44\n" +
                        "Girona         Perpignan        93   38");
                osw.flush();
                osw.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            File file2 = new File(getFilesDir().getPath() + "/cidades.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
            String receiveString = "";
            while ((receiveString = bufferedReader.readLine()) != null ) {
                Cidade c = new Cidade(receiveString);
                //Popula a lista de Cidades e a Tabela de Hash de Cidades
                listaCidades.inserirAposFim(c);
                hashCidades.insert(c);
                qtasCidades++;
            }
            //Cria o grafo com as cidades
            criarGrafo();
            Object arrayCidadesObject[] = listaCidades.toArray();
            Cidade[] arrayCidades = new Cidade[arrayCidadesObject.length];
            for(int i = 0; i < arrayCidadesObject.length; i++)
                arrayCidades[i] = (Cidade)arrayCidadesObject[i];

            //Desenha os pontos no mapa
            desenharPontos(arrayCidades);

            String arrayNomeCidades[] = new String[arrayCidades.length];
            for(int i = 0; i < arrayCidadesObject.length; i++)
                arrayNomeCidades[i] = arrayCidades[i].getNomeCidade();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, arrayNomeCidades);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            //Seta os adaptadores de array de cidade
            spOrigem.setAdapter(adapter);
            spDestino.setAdapter(adapter);
            bufferedReader.close();
        }
        //Se algo deu errado, avisa o usuario
        catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não encontrado", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não pode ser lido", Toast.LENGTH_SHORT).show();
        }

        //No onclick do botao de buscar caminho, busca todos os caminhos usando backtracking e acha o melhor usando dijkstra
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarCaminhosDijkstra(spOrigem.getSelectedItemPosition(), spDestino.getSelectedItemPosition());
                buscarCaminhosBackingTrack(spOrigem.getSelectedItemPosition(), spDestino.getSelectedItemPosition());
            }
        });

        //No onclick do botao de adicionar cidades, redireciona para outra view onde as cidades podem ser adicionadas
        btnAddCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdicionarCidadeActivity.class);
                intent.putExtra("listaCidades", listaCidades);
                intent.putExtra("qtosDados",qtasCidades);
                startActivityForResult(intent,1);
            }
        });

        //No onclick do botao de adicionar caminhos, redireciona para outra view onde os caminhos podem ser adicionados
        btnAddCaminho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdicionarCaminhoActivity.class);
                intent.putExtra("listaCaminhos", listaCaminhos);
                intent.putExtra("listaCidades", listaCidades);
                startActivityForResult(intent,2);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //Se o codigo for 1 adiciona Cidade
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
        //Se for 2, adiciona caminho
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

    //Recria o grafo, usado quando uma nova cidade eh adicionada
    public void recriarGrafo(){
        matAdjacencias = new Caminho[qtasCidades][qtasCidades];
        for(NoLista<Caminho> atual = listaCaminhos.getPrimeiro(); atual.getProx() != null; atual = atual.getProx()) {
            Caminho c = atual.getInfo();
            Cidade cAuxOrigem = hashCidades.procurarCidade(c.getNomeCidadeOrigem());
            Cidade cAuxDestino = hashCidades.procurarCidade(c.getNomeCidadeDestino());
            matAdjacencias[cAuxOrigem.getIdCidade()][cAuxDestino.getIdCidade()] = c;
        }
    }

    //Cria o grafo
    public void criarGrafo() {
        matAdjacencias = new Caminho[qtasCidades][qtasCidades];
        try {
            File file2 = new File(getFilesDir().getPath() + "/caminhos.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
            String receiveString = "";

            listaCaminhos = new ListaSimples<>();
            //Adiciona as informacoes dos caminhos na matriz de adjacencias
            while ((receiveString = bufferedReader.readLine()) != null ) {
                Caminho c = new Caminho(receiveString);
                Cidade cAuxOrigem = hashCidades.procurarCidade(c.getNomeCidadeOrigem());
                Cidade cAuxDestino = hashCidades.procurarCidade(c.getNomeCidadeDestino());
                matAdjacencias[cAuxOrigem.getIdCidade()][cAuxDestino.getIdCidade()] = c;
                listaCaminhos.inserirAposFim(c);
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

    //Busca o caminho pelo algoritmo de Dijkstra
    public void buscarCaminhosDijkstra(int cdOrigem, int cdDestino){

        grafo = new Grafo(qtasCidades);
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

    //Usa backtracking para achar todos os caminhos
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

    //Exibe os caminhos na tela
    public void exibirCaminhos(PilhaLista<PilhaLista<Caminho>> caminhos) {
        PilhaLista<PilhaLista<Caminho>> pilhaCopia = caminhos.copia();
        ListaSimples<Cidade> cidadesPrintar, todosOsCaminhos = new ListaSimples<>();
        Cidade[] cidadesAPrintar = null;
        int tamanhoAtual = 0;

        //Enquanto a pilha de caminhos nao esta vazia, desempilha caminhos e exibe eles
        while(!pilhaCopia.estaVazia()){
            try{
                PilhaLista<Caminho> pcAtual = pilhaCopia.desempilhar();

                Caminho cAtual = null;
                cidadesPrintar = new ListaSimples<>();
                //Vai guardando as cidades a printar em uma lista
                while (!pcAtual.estaVazia())
                {
                    cAtual = pcAtual.desempilhar();
                    int indiceO = hashCidades.hash(cAtual.getNomeCidadeOrigem());
                    int indiceD = hashCidades.hash(cAtual.getNomeCidadeDestino());
                    cidadesPrintar.inserirAposFim(arrayCidadesHash[indiceO].getPrimeiro().getInfo());
                    cidadesPrintar.inserirAposFim(arrayCidadesHash[indiceD].getPrimeiro().getInfo());
                }
                Object[] o = cidadesPrintar.toArray();
                tamanhoAtual += o.length;
                for(int indiceObj = 0; indiceObj < o.length; indiceObj++)
                    todosOsCaminhos.inserirAposFim((Cidade)o[indiceObj]);
            }catch (Exception e){
                e.printStackTrace();
            }
            cidadesAPrintar = new Cidade[tamanhoAtual];
            Object[] o = todosOsCaminhos.toArray();
            for(int indiceObj = 0; indiceObj < tamanhoAtual; indiceObj++)
                cidadesAPrintar[indiceObj] = (Cidade)o[indiceObj];

            //printa todas as cidades
            desenharLinhas(cidadesAPrintar);
        }
    }

    //Desenha os pontos que representam as cidades
    public void desenharPontos(Cidade[] cidades) {
        Bitmap bmp = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        Canvas ponto = new Canvas(bmp);
        canvaImagem.setePonto(true);
        canvaImagem.setCidades(cidades);
        canvaImagem.draw(ponto);
    }

    //Desenha as linhas que representam os caminhos entre as cidades
    public void desenharLinhas(Cidade[] cidades){
        canvaImagem.setePonto(false);
        canvaImagem.setCidades(cidades);
        canvaImagem.invalidate();
        Object[] obj = listaCidades.toArray();
        Cidade[] arrayCid = new Cidade[obj.length];
        for(int i = 0; i < arrayCid.length; i++)
            arrayCid[i] = (Cidade) obj[i];
        canvaImagem.seteDijkstra(true);
        canvaImagem.setCidades(arrayCid);
        canvaImagem.setVerticesDijkstra(grafo.getVerticesPassados());
        canvaImagem.invalidate();
    }
}
