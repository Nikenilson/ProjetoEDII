package br.unicamp.cotuca.pathbetweencities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;

public class MainActivity extends AppCompatActivity {

    Button btnBuscar, btnAddCidade, btnAddCaminho;
    Spinner spOrigem, spDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscar = findViewById(R.id.btnBuscar);
        btnAddCaminho = findViewById(R.id.btnAddCaminho);
        btnAddCidade = findViewById(R.id.btnAddCidade);
        spOrigem = findViewById(R.id.spOrigem);
        spDestino = findViewById(R.id.spDestino);

        String[] arrayCidades = new String[256];

        try {
            InputStream inputStream = openFileInput("Cidades.txt");

            if (inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                int i = 0;
                while ((receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                    Cidade c = new Cidade(receiveString);
                    arrayCidades[i] = c.getNomeCidade();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, arrayCidades);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spOrigem.setAdapter(adapter);

                inputStream.close();
                //ret = stringBuilder.toString();
            }
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
