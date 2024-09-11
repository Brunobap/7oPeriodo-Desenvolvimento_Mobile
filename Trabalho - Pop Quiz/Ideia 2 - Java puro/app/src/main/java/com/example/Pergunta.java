package com.example;

public class Pergunta {
    public String respCerta, enunciado, materia;
    public String[] respsErradas;
    public int peso;

    public Pergunta(String respCerta, String enunciado, String materia, String[] respsErradas, int peso) {
        this.respCerta = respCerta;
        this.enunciado = enunciado;
        this.materia = materia;
        this.respsErradas = respsErradas;
        this.peso = peso;
    }
}
