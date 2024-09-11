package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projeto.R;

public class TelaPrincipal extends AppCompatActivity {

    private Button btnNovaPartida, btnVerConquistas;
    private TextView textNomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // TODO: Fazer uma requisição para buscar o nome do jogador
        textNomeUsuario = (TextView) findViewById(R.id.textNomeUsuario);

        btnNovaPartida = (Button) findViewById(R.id.btnNovaPartida);
        btnNovaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, TelaCategorias.class);
                startActivity(intent);
            }
        });

        btnVerConquistas = (Button) findViewById(R.id.btnVerConquistas);
        btnVerConquistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, MinhasConquistas.class);
                startActivity(intent);
            }
        });
    }

}