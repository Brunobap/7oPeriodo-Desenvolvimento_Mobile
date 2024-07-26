package com.example.a240307;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashFinale extends AppCompatActivity implements Runnable {

    private Handler handler;

    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_finale);

        shared = getSharedPreferences("acesso1",0);
        String nome = shared.getString("nome", "(nome vai aqui)");

        handler = new Handler();
        handler.postDelayed(this,5000);
    }

    @Override
    public void run() {
        // Encerrar o app
        this.finish();
    }
}