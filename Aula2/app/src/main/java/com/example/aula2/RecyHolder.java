package com.example.aula2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyHolder extends RecyclerView.ViewHolder {

    protected TextView nome, curso, ano;
    public RecyHolder(@NonNull View itemView) {
        super(itemView);
        this.nome = itemView.findViewById(R.id.textView);
        this.curso = itemView.findViewById(R.id.textView2);
        this.ano = itemView.findViewById(R.id.textView3);
    }
}
