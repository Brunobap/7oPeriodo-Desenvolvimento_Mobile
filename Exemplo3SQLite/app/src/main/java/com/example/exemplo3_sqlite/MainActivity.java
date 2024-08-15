package com.example.exemplo3_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNome, txtProfissao, txtCpf;
    private TextView txtResultado;
    private Button btnSalvar, btnRecuperar, btnAtualizar;
    private ArrayList<Pessoa> lista;
    private Banco banco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.editTextText);
        txtCpf = findViewById(R.id.editTextText2);
        txtProfissao = findViewById(R.id.editTextText3);

        txtResultado = findViewById(R.id.res);

        btnSalvar = (Button) findViewById(R.id.button);
        btnSalvar.setOnClickListener(this);
        btnRecuperar = (Button) findViewById(R.id.button2);
        btnRecuperar.setOnClickListener(this);

        banco = new Banco(getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        if (v == btnSalvar){
            Pessoa p = new Pessoa();
            String nome, cpf, profissao;
            p.setNome(txtNome.getText().toString());
            p.setCpf(txtCpf.getText().toString());
            p.setProfissao(txtProfissao.getText().toString());
            banco.saveData(p);
            Toast.makeText(this,"Salvo!",Toast.LENGTH_LONG).show();
        } else if (v == btnRecuperar) {
            lista = banco.buscaDados();
            String res = "";
            for (int i=0; i<lista.size(); i++){
                Pessoa p = lista.get(i);
                Log.d("##","ID: "+Integer.toString(p.getId()));
                Log.d("##","Nome: "+p.getNome());
                Log.d("##","CPF: "+p.getCpf());
                Log.d("##","Profissao: "+p.getProfissao());
                res += p.getNome();
            }
            txtResultado.setText(res);
        }
    }
}