package com.example.a240307;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class InputIMC extends AppCompatActivity implements View.OnClickListener {

    private TextView txtNome;
    private TextInputEditText cxPeso, cxAltura;
    private FloatingActionButton btn;
    private String nome;
    private Toolbar toolbar;
    private CoordinatorLayout layte;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_imc);

        layte = findViewById(R.id.fundin);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Calculadora de IMC");
        toolbar.setSubtitle("Resultado rápido e fácil");
        // colocando "ações" na toolbar
        setSupportActionBar(toolbar);
        //
        ActionBar action = getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);


        Intent i = getIntent();
        nome = "";
        Bundle caxa;
        /* Maneira alternativa, passando direto
        String nome = (String) i.getExtras().get("nome");*/
        if (i != null) {
            caxa = i.getExtras();
            if (caxa != null) {
                nome = caxa.getString("nome", "(nome vai aqui)");
            }
        }
        Log.i("Chave", "Nome obtido: "+nome);

        txtNome = (TextView) findViewById(R.id.textView);
        CharSequence texto = "Bem-vindo, "+nome;
        txtNome.setText(texto);

        cxPeso = findViewById(R.id.cxPeso);
        cxAltura = findViewById(R.id.cxAltura);
        btn = findViewById(R.id.button2);

        btn.setOnClickListener(this);
    }

    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu (Menu menu1){
        // Inflar o menu
        MenuInflater infla = getMenuInflater();
        infla.inflate(R.menu.menu, menu1);

        // Mostrar os itens quando "guardados"
        if (menu1 instanceof MenuBuilder){
            MenuBuilder menuBuilder = (MenuBuilder) menu1;
            menuBuilder.setOptionalIconsVisible(true);
        }

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //Toast.makeText(this, "Você ganhou "+item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (!cxPeso.getText().toString().isEmpty() && !cxAltura.getText().toString().isEmpty()) {
            int peso = Integer.parseInt(cxPeso.getText().toString());
            float altura = Float.parseFloat(cxAltura.getText().toString());

            float imc = peso / (altura * altura);

            Intent i = new Intent(this, OutputIMC.class);

            Bundle caixa = new Bundle();
            caixa.putFloat("imc", imc);
            caixa.putString("nome", nome);
            i.putExtras(caixa);
            startActivity(i);
        } else {
            Snackbar snackbar = Snackbar.make(layte, "Digite seus dados corretamente, por favor.", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("Fechar", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
        }
    }
}