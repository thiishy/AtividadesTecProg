package br.edu.fatecpg.sistema.view;

import br.edu.fatecpg.sistema.model.Aluno;
import br.edu.fatecpg.sistema.model.Treinamento;
import br.edu.fatecpg.sistema.model.TreinamentoPresencial;
import br.edu.fatecpg.sistema.model.TreinamentoOnline;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Javeiro 1", 8, 75);
        Aluno aluno2 = new Aluno("Javeiro 2", 9, 80);
        Aluno aluno3 = new Aluno("Javeiro 3", 10, 85);

        TreinamentoOnline treinoOnline = new TreinamentoOnline(1, "Ale", "Java", 15, 18);
        TreinamentoPresencial treinoPresencial = new TreinamentoPresencial(2, "Sandro", "Java", 13, 16);
        treinoPresencial.definirCargaHoraria(80);

        treinoPresencial.definirLocal("Fatec");
        treinoOnline.definirLinkAcesso("https://fatecpg.cps.sp.gov.br/");

        treinoPresencial.adicionarAluno(aluno1);
        treinoPresencial.adicionarAluno(aluno2);
        treinoPresencial.adicionarAluno(aluno3);

        treinoPresencial.verificarUltimoTreinamento(aluno2);
        treinoPresencial.verificarUltimoTreinamento(aluno3);

        treinoPresencial.verificarDisponibilidade();
        treinoPresencial.calcularMediaAlunos();
    }
}
