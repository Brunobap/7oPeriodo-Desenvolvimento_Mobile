package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projeto.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FormCadastro extends AppCompatActivity {

    private EditText txtNome, txtEmail, txtSenha, txtConfSenha;
    private TextView txtLogin;
    private Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNome = (EditText) findViewById(R.id.edit_nome);
        txtEmail = (EditText) findViewById(R.id.edit_email);
        txtSenha = (EditText) findViewById(R.id.edit_senha);
        txtConfSenha = (EditText) findViewById(R.id.edit_confirma_senha);

        txtLogin = (TextView) findViewById(R.id.text_tela_login);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                startActivity(intent);
            }
        });

        btnCadastro = (Button) findViewById(R.id.btn_cadastrar);
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String senha = txtSenha.getText().toString();
                String confirmarSenha = txtConfSenha.getText().toString();

                // Verificar se as senhas sÃ£o iguais
                if (!senha.equals(confirmarSenha) || senha.length()==0) {
                    System.err.println("Digite suas senha corretamente");

                } else {
                    // Senhas iguais, pode avanÃ§ar para a prÃ³xima tela
                    try {
                        Connection con= DriverManager.getConnection(
                                "jdbc:mysql://popquiz.c98wqcaqenn5.sa-east-1.rds.amazonaws.com:3306/popQuiz",
                                "admin","popQuiz00");
                        System.out.println("INSERINDO DADOS");
                        PreparedStatement ptmt=con.prepareStatement("INSERT INTO usuarios(email,senha) VALUES(?,?)");
                        ptmt.setString(1, txtEmail.getText().toString());
                        ptmt.setString(2, senha);
                        ptmt.executeUpdate();

                        Intent intent = new Intent(FormCadastro.this, TelaPrincipal.class);
                        startActivity(intent);
                    }
                    catch (Exception execao){
                        System.out.println(execao);
                    }
                }
            }
        });
    }
}