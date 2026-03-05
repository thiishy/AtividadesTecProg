package br.edu.fatecpg.sistema.model;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.OptionalDouble;

public abstract class Treinamento {
    private int id;
    private String nomeInstrutor;
    private String linguagemEnsinada;
    private int horarioInicio;
    private int horarioFim;
    private int cargaHoraria;
    private List<Aluno> alunos = new ArrayList<>();

    public Treinamento(int id, String nomeInstrutor, String linguagemEnsinada, int horarioInicio, int horarioFim) {
        this.id = id;
        this.nomeInstrutor = nomeInstrutor;
        this.linguagemEnsinada = linguagemEnsinada;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public void verificarDisponibilidade() {
        int horaAtual = LocalDateTime.now().getHour();

        if(horaAtual >= horarioInicio && horaAtual <= horarioFim) {
            System.out.println("O instrutor está disponível.");
        } else {
            System.out.println("O instrutor só está disponível das " + horarioInicio + "h até as " + horarioFim + "h.");
        }
    }

    public void definirCargaHoraria(int horas) {
        this.cargaHoraria = horas;
        System.out.println("Carga horária definida para " + horas + " horas.");
    }

    public void verificarUltimoTreinamento(Aluno aluno) {
        if(aluno.getHoras() > this.cargaHoraria) {
            System.out.println("O programador não está apto a fazer o treinamento.");
        } else {
            System.out.println("O programador está apto a fazer o treinamento.");
        }
    }

    public void calcularMediaAlunos() {
        OptionalDouble media = alunos.stream().mapToDouble(Aluno::getNotaFinal).average();
        if(media.isPresent()) {
            System.out.println("Média dos alunos: " + media.getAsDouble());
        } else {
            System.out.println("Não foi possível calcular a média dos alunos.");
        }
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno '" + aluno.getNome() + "' adicionado com sucesso!");
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
        System.out.println("Aluno '" + aluno.getNome() + "' removido com sucesso!");
    }
}
