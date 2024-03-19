package com.example.a240307;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class InputIMC extends AppCompatActivity implements View.OnClickListener {

    private TextView txtNome;
    private TextInputEditText cxPeso, cxAltura;
    private Button btn;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_imc);

        Intent i = getIntent();
        nome = "(nome vai aqui)";
        Bundle caxa;
        /* Maneira alternativa, passando direto
        String nome = (String) i.getExtras().get("nome");*/
        if (i != null) {
            caxa = i.getExtras();
            if (caxa != null) {
                nome = caxa.getString("nome");
            }
        }
        Log.i("Chave", "Nome obtido: "+nome);

        txtNome = (TextView) findViewById(R.id.textView);
        CharSequence texto = "Bem-vindo, "+nome;
        txtNome.setText(texto);

        cxPeso = (TextInputEditText) findViewById(R.id.cxPeso);
        cxAltura = (TextInputEditText) findViewById(R.id.cxAltura);
        btn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int peso = Integer.parseInt(cxPeso.getText().toString());
        float altura = Float.parseFloat(cxAltura.getText().toString());

        float imc = peso / (altura * altura);

        Intent i = new Intent(this, OutputIMC.class);

        Bundle caixa = new Bundle();
        caixa.putFloat("imc",imc);
        caixa.putString("nome",nome);
        i.putExtras(caixa);
        startActivity(i);

        this.finish();
    }
}