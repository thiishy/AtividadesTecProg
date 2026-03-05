package br.edu.fatecpg.sistema.model;

public class TreinamentoPresencial extends Treinamento {
    private String local;

    public TreinamentoPresencial(int id, String nomeInstrutor, String linguagemEnsinada, int horarioInicio, int horarioFim) {
        super(id, nomeInstrutor, linguagemEnsinada, horarioInicio, horarioFim);
    }

    public String getLocal() {
        return local;
    }

    public void definirLocal(String local) {
        this.local = local;
        System.out.println("Local '" + local + "' definido com sucesso.");
    }
}
