package br.unicamp.cotuca.pathbetweencities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedWriter;
import java.io.FileWriter;

import br.unicamp.cotuca.pathbetweencities.caminho.Caminho;
import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;
import br.unicamp.cotuca.pathbetweencities.lista.ListaSimples;

public class AdicionarCaminhoActivity extends AppCompatActivity {

    Spinner spinnerOrigem, spinnerDestino;
    EditText edtDistancia, edtTempo;
    Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_caminho);

        spinnerOrigem = findViewById(R.id.spinnerOrigem);
        spinnerDestino = findViewById(R.id.spinnerDestino);
        edtDistancia = findViewById(R.id.edtDistancia);
        edtTempo = findViewById(R.id.edtTempo);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        ListaSimples<Cidade> listaCidades = (ListaSimples<Cidade>) getIntent().getSerializableExtra("listaCidades");
        Object[] objs = listaCidades.toArray();
        String[] arrayNomeCidades = new String[listaCidades.getQuantosNos()];
        for(int i = 0; i < arrayNomeCidades.length; i++)
            arrayNomeCidades[i] = ((Cidade) objs[i]).getNomeCidade();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayNomeCidades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrigem.setAdapter(adapter);
        spinnerDestino.setAdapter(adapter);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListaSimples<Caminho> listaCaminhos = null;
                if(spinnerOrigem.getSelectedItem() != spinnerDestino.getSelectedItem()){
                    if(!edtDistancia.getText().toString().trim().equals("") &&
                    !edtTempo.getText().toString().trim().equals("")){
                        Caminho c = new Caminho(spinnerOrigem.getSelectedItem().toString(), spinnerDestino.getSelectedItem().toString(),
                                Integer.parseInt(edtDistancia.getText().toString()), Integer.parseInt(edtTempo.getText().toString()));

                        listaCaminhos = (ListaSimples<Caminho>) getIntent().getSerializableExtra("listaCaminhos");
                        listaCaminhos.inserirAposFim(c);

                        try{
                            FileWriter fw = new FileWriter(getFilesDir().getPath() + "/caminhos.txt", true);
                            BufferedWriter osw = new BufferedWriter(fw);
                            osw.write("\n" + c.toString());
                            osw.flush();
                            osw.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("listaCaminhos", listaCaminhos);
                        setResult(Activity.RESULT_OK,intent);
                        finish();
                    }
                }//preencha tudo
            }
        });
    }
}
