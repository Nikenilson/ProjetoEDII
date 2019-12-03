package br.unicamp.cotuca.pathbetweencities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileWriter;

import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;
import br.unicamp.cotuca.pathbetweencities.lista.ListaSimples;

public class AdicionarCidadeActivity extends AppCompatActivity {

    EditText edtNomeCidade, edtCoordX, edtCoordY;
    Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_cidade);

        edtNomeCidade = findViewById(R.id.edtNomeCidade);
        edtCoordX = findViewById(R.id.edtCoordX);
        edtCoordY = findViewById(R.id.edtCoordY);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qtosDados = 0;
                ListaSimples<Cidade> lista = null;
                Cidade c = null;
                if(!edtCoordX.getText().toString().trim().equals("") && !edtCoordY.getText().toString().trim().equals("")){
                    float f1 = Float.parseFloat(edtCoordX.getText().toString());
                    float f2 = Float.parseFloat(edtCoordY.getText().toString());
                    qtosDados = (int) getIntent().getSerializableExtra("qtosDados");
                    c = new Cidade(qtosDados, f1 , f2, edtNomeCidade.getText().toString());
                    lista = (ListaSimples<Cidade>) getIntent().getSerializableExtra("listaCidades");
                    lista.inserirAposFim(c);
                }

                try{
                    FileWriter fw = new FileWriter(getFilesDir().getPath() + "/cidades.txt", true);
                    BufferedWriter osw = new BufferedWriter(fw);
                    osw.write("\n" + c.toString());
                    osw.flush();
                    osw.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

                Intent result = new Intent();
                result.putExtra("qtosDados",qtosDados);
                result.putExtra("listaCidades", lista);
                setResult(Activity.RESULT_OK,result);
                finish();
            }
        });
    }
}
