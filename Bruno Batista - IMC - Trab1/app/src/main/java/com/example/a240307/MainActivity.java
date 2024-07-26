package com.example.a240307;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {

    private ImageView cavera;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("##", "onCreate: estou em SplashInicial");

        cavera = (ImageView) findViewById(R.id.imageView);
        cavera.setOnClickListener(this);

        handler = new Handler();
        handler.postDelayed(this,2000);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("##", "onStart: estou em SplashInicial");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("##", "onPause: estou em SplashInicial");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("##", "onRestart: estou em SplashInicial");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("##", "onStop: estou em SplashInicial");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("##", "onDestroy: estou em SplashInicial");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("##", "onResume: estou em SplashInicial");
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    @Override
    public void run() {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        this.finish();
    }
}