package br.edu.fatecpg.sistema.model;

public class TreinamentoOnline extends Treinamento {
    private String linkAcesso;

    public TreinamentoOnline(int id, String nomeInstrutor, String linguagemEnsinada, int horarioInicio, int horarioFim) {
        super(id, nomeInstrutor, linguagemEnsinada, horarioInicio, horarioFim);
    }

    public String getLinkAcesso() {
        return linkAcesso;
    }

    public void definirLinkAcesso(String linkAcesso) {
        this.linkAcesso = linkAcesso;
        System.out.println("Link de acesso definido para: " + linkAcesso);
    }
}
