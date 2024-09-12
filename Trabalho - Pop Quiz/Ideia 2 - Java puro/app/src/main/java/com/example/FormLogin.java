package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FormLogin extends AppCompatActivity {

    private TextView text_tela_cadastre;
    private EditText edit_email, edit_senha;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        IniciarComponentes();

        text_tela_cadastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormLogin.this, FormCadastro.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Connection con= DriverManager.getConnection(
                            "jdbc:mysql://popquiz.c98wqcaqenn5.sa-east-1.rds.amazonaws.com:3306/popQuiz",
                            "admin","popQuiz00");
                    System.out.println("VERIFICANDO DADOS");
                    Statement stmt=con.createStatement();
                    String email = edit_email.getText().toString();
                    String senha = edit_senha.getText().toString();
                    String sql="Select * from usuarios where email='"+email+"' and senha='"+senha+"'";
                    ResultSet rs=stmt.executeQuery(sql);
                    if(rs.next()) {
                        Intent intent = new Intent(FormLogin.this, TelaPrincipal.class);
                        startActivity(intent);
                    }
                    else {
                        System.err.println("Login falhou");
                        con.close();
                        return;
                    }
                }
                catch (Exception execao){
                    System.out.println(execao);
                }

                Intent intent = new Intent(FormLogin.this, TelaPrincipal.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes(){
        text_tela_cadastre = findViewById(R.id.text_tela_cadastro);
        btnLogin = findViewById(R.id.bt_Login);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
    }
}