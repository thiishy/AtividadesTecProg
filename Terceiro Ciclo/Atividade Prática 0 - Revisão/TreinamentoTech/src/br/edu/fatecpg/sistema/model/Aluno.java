package br.edu.fatecpg.sistema.model;

public class Aluno {
    private String nome;
    private double notaFinal;
    private int horas;

    public Aluno(String nome, double notaFinal, int horas) {
        this.nome = nome;
        this.notaFinal = notaFinal;
        this.horas = horas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}
