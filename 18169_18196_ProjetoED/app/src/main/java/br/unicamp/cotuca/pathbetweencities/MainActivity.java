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
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;
import br.unicamp.cotuca.pathbetweencities.lista.ListaSimples;

public class MainActivity extends AppCompatActivity {

    Button btnBuscar, btnAddCidade, btnAddCaminho;
    Spinner spOrigem, spDestino;
    public static final int PERMISSION_EXTERNAL_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscar = findViewById(R.id.btnBuscar);
        btnAddCaminho = findViewById(R.id.btnAddCaminho);
        btnAddCidade = findViewById(R.id.btnAddCidade);
        spOrigem = findViewById(R.id.spOrigem);
        spDestino = findViewById(R.id.spDestino);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSION_EXTERNAL_STORAGE);
        ListaSimples<String> listaCidades = new ListaSimples<>();
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard.getPath() + "/Download/Cidades.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String receiveString = "";

            int i = 0;
            while ((receiveString = bufferedReader.readLine()) != null ) {
                stringBuilder.append(receiveString);
                Cidade c = new Cidade(receiveString);
                listaCidades.InserirAposFim(c.getNomeCidade());
            }
            String arrayCidades[] = listaCidades.toArray();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, arrayCidades);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spOrigem.setAdapter(adapter);
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não encontrado", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Arquivo não pode ser lido", Toast.LENGTH_SHORT).show();
        }

        btnAddCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this, );
            }
        });
    }
}
