package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager manager;
    private ArrayList<Alunos>lista = new ArrayList<Alunos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarAlunos();
        Alunos b = new Alunos("","", "");
        lista.add(b);

        Adaptador adaptador = new Adaptador(lista, getApplicationContext());
        recycler = findViewById(R.id.recycleView);
        manager = new LinearLayoutManager(this);

        recycler.setLayoutManager(manager);
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adaptador);
    }

    public void carregarAlunos(){
        Alunos a;
        for (int i=0; i<10; i++){
            a = new Alunos("aluno "+i, "Eng de "+i, "202"+i);
           lista.add(a);
        }
    }
}