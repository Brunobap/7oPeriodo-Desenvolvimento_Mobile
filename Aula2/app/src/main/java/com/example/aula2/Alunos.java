package com.example.aula2;

public class Alunos {
    public Alunos (String nome, String curso, String ano) {
        this.nome = nome;
        this.curso = curso;
        this.ano = ano;
    }

    private String nome, curso, ano;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
