package com.example.a240307;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText cxNome, cxSenha;
    private Button btn;

    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d("##", "onCreate: estou em Login");

        cxNome = (TextInputEditText) findViewById(R.id.cxNome);
        cxSenha = (TextInputEditText) findViewById(R.id.cxSenha);
        btn = (Button) findViewById(R.id.button);

        if (savedInstanceState != null){
            if (!savedInstanceState.isEmpty()){
                cxNome.setText(savedInstanceState.getString("nome"));
            }
        }

        btn.setOnClickListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("##", "onStart: estou em Login");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("##", "onResume: estou em Login");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("##", "onPause: estou em Login");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("##", "onRestart: estou em Login");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("##", "onStop: estou em Login");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("##", "onDestroy: estou em Login");
    }

    @Override
    public void onSaveInstanceState(Bundle b) {
        String nome = "(nome vai aqui)";
        b.putString("nome",nome);
        super.onSaveInstanceState(b);
    }

    @Override
    public void onClick(View v) {
        String nome = cxNome.getText().toString(), senha = cxSenha.getText().toString();

        // Envia a todas as activities
        shared = getSharedPreferences("acesso1", 0);
        SharedPreferences.Editor gravador = shared.edit();
        gravador.putString("nome", nome);
        gravador.commit();


        Log.i("Chave", "Nome digitado: "+nome);
        Log.i("Chave", "Senha digitada: "+senha);

        Intent i = new Intent(this, InputIMC.class);
        /* Outra maneira de enviar dados, enviar direto
        i.putExtra("nome",nome);*/

        Bundle caixa = new Bundle();
        caixa.putString("nome",nome);
        i.putExtras(caixa);
        startActivity(i);

        // Mensagem de bolhinha na tela
        Toast.makeText(this, "Logado com sucesso", Toast.LENGTH_LONG).show();
    }
}