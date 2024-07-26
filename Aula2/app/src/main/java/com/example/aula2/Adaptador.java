package com.example.aula2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<RecyHolder> implements View.OnClickListener {
    private Context context;
    private ArrayList<Alunos> lista = new ArrayList<Alunos>();
    public Adaptador(ArrayList<Alunos> lista, Context context){
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout, parent, false
        );
        return new RecyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyHolder holder, int position) {
        holder.nome.setText(lista.get(position).getNome());
        holder.curso.setText(lista.get(position).getCurso());
        holder.ano.setText(lista.get(position).getAno());
        holder.nome.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

    public void onClick(View v){
        TextView t = (TextView) v;
        Log.d("##", t.getText().toString());
        Intent i = new Intent(this.context, MainActivity2.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.context.startActivity(i);
    }
}
