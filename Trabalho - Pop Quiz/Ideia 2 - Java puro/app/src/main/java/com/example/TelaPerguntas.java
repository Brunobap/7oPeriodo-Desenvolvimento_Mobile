package com.example;

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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TelaPerguntas extends AppCompatActivity {

    private TextView textPergunta;
    private Button[] botoes;

    // Variáveis para o funcionamento do jogo
    private int ponteiro, lugarCerto, pontuacao;
    private Pergunta[] perguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_perguntas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        try {
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://popquiz.c98wqcaqenn5.sa-east-1.rds.amazonaws.com:3306/popQuiz",
                    "admin","popQuiz00");
            System.out.println("BUSCANDO PERGUNTAS");
            Statement stmt = con.createStatement();
            String sql = "Select * from quizzes where nome='Matematica'";
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()) {
                int tam = 5;
                perguntas = new Pergunta[tam];

                for (int i=1; i<=tam; i++) {
                    stmt = con.createStatement();
                    sql = "Select * from perguntas where id="+i;
                    ResultSet res = stmt.executeQuery(sql);

                    if (res.next()) {
                        int peso = res.getInt("peso");
                        String materia = res.getString("materia");
                        String enunciado = res.getString("enunciado");
                        String respCerta = res.getString("respCerta");
                        String erradas = res.getString("respErradas");

                        String[] respErradas = erradas.split(",");
                        for (int j=0; j<3; j++) {
                            String resp = respErradas[j];
                            respErradas[j] = resp.substring(1, resp.length()-1);
                        }

                        Pergunta p = new Pergunta(respCerta, enunciado, materia, respErradas, peso);
                        perguntas[i-1] = p;

                    } else {
                        System.err.println("Falha ao carregar as perguntas");
                        con.close();
                        return;
                    }
                }

            } else {
                System.err.println("Falha ao carregar as perguntas");
                con.close();
                return;
            }

        } catch (Exception exception) {
            System.err.println(exception.toString());
        }

        textPergunta = findViewById(R.id.text_pergunta);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(clicou);

        Button btn1 = findViewById(R.id.button2);
        btn1.setOnClickListener(clicou);

        Button btn2 = findViewById(R.id.button3);
        btn2.setOnClickListener(clicou);

        Button btn3= findViewById(R.id.button4);
        btn3.setOnClickListener(clicou);

        botoes = new Button[4];
        botoes[0] = btn;
        botoes[1] = btn1;
        botoes[2] = btn2;
        botoes[3] = btn3;

        this.lugarCerto = (int) Math.round(Math.random()*3);
        this.pontuacao = 0;
        this.ponteiro = 0;

        atualizaTela();
    }

    private final View.OnClickListener clicou = new View.OnClickListener() {
        public void onClick(View view) {

        }
    };

    private void atualizaTela(){
        if (ponteiro >= perguntas.length) {
            System.out.println(this.pontuacao);
            // TODO: tela de pontuação e fechar essa tela
            return ;
        }

        textPergunta.setText(perguntas[ponteiro].enunciado);

        ArrayList<Integer> posicoes = new ArrayList<Integer>();
        posicoes.add(0); posicoes.add(1); posicoes.add(2);

        this.lugarCerto = (int) Math.round(Math.random()*3);

        String txtResp = "";
        if (lugarCerto == 0) txtResp = perguntas[ponteiro].respCerta;
        else {
            int remove = (int) (Math.random() * (posicoes.size() - 1));
            int pos = posicoes.remove(remove);
            txtResp = perguntas[ponteiro].respsErradas[pos];
        } this.botoes[0].setText(txtResp);

        if (lugarCerto == 1) txtResp = perguntas[ponteiro].respCerta;
        else {
            int remove = (int) (Math.random() * (posicoes.size() - 1));
            int pos = posicoes.remove(remove);
            txtResp = perguntas[ponteiro].respsErradas[pos];
        } this.botoes[1].setText(txtResp);

        if (lugarCerto == 2) txtResp = perguntas[ponteiro].respCerta;
        else {
            int remove = (int) (Math.random() * (posicoes.size() - 1));
            int pos = posicoes.remove(remove);
            txtResp = perguntas[ponteiro].respsErradas[pos];
        } this.botoes[2].setText(txtResp);

        if (lugarCerto == 3) txtResp = perguntas[ponteiro].respCerta;
        else {
            int remove = (int) (Math.random() * (posicoes.size() - 1));
            int pos = posicoes.remove(remove);
            txtResp = perguntas[ponteiro].respsErradas[pos];
        } this.botoes[3].setText(txtResp);
    }
}