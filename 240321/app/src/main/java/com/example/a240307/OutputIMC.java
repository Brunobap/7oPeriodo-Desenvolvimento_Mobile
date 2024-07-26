package com.example.a240307;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OutputIMC extends AppCompatActivity implements View.OnClickListener {

    private EditText cxResultado;
    private TextView cxNome;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_imc);

        Intent i = this.getIntent();
        float imc = 0;
        String nome = "";
        if (i != null) {
            Bundle caxa = i.getExtras();
            if (caxa != null) {
                imc = caxa.getFloat("imc", 0);
                nome = caxa.getString("nome", "(nome vai aqui)");
            }
        }

        cxNome = (TextView) findViewById(R.id.textView2);
        cxResultado = (EditText) findViewById(R.id.editTextText);

        nome += ",";
        String res = "Seu IMC é\n" + (int) imc + "\n";
        cxNome.setText(nome);

        if (imc < 18.5) res += "'Abaixo do Peso'";
        else if (imc < 25) res += "'Peso Normal'";
        else if (imc < 30) res += "'Sobrepeso'";
        else if (imc < 35) res += "'Obesidade I'";
        else if (imc < 40) res += "'Obesidade II'";
        else res += "'Obesidade Mórbida'";
        cxResultado.setText(res);

        btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, SplashFinale.class);
        startActivity(i);
    }
}