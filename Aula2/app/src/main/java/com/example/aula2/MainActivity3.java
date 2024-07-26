package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private LinearLayout layout;
    private TextView texto;
    private Button vet[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //layout.setBackgroundColor(Color.BLUE);
        layout.setBackgroundColor(Color.parseColor("#FF6D54"));

        texto = new TextView(this);
        texto.setText("Eu odeio Java");
        layout.addView(texto);

        vet = new Button[20];
        for (int i=0; i<vet.length; i++){
            vet[i] = new Button(this);
            vet[i].setText("Botão "+i);
            layout.addView(vet[i]);
        }

        setContentView(layout);
    }
}