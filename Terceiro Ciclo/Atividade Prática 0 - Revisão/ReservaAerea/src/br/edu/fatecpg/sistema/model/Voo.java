package br.edu.fatecpg.sistema.model;

public class Voo {
    private String numeroVoo;
    private String origem;
    private String destino;
    private String tipo;
    private boolean pontosTuristicos;
    private int assentosDisponiveis;

    public Voo(String numeroVoo, String destino, int assentosDisponiveis, String origem) {
        this.numeroVoo = numeroVoo;
        this.destino = destino;
        this.assentosDisponiveis = assentosDisponiveis;
        this.origem = origem;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void realizarReserva(int quantidadeAssentos) {
        if(this.assentosDisponiveis - quantidadeAssentos >= 0) {
            this.assentosDisponiveis -= quantidadeAssentos;
            System.out.println("Reserva de " + quantidadeAssentos + " assentos realizada com sucesso.");
        } else {
            System.out.println("Não há assentos disponíveis.");
        }
    }

    public void verificarDisponibilidade(int quantidadeAssentos) {
        if(this.assentosDisponiveis - quantidadeAssentos >= 0) {
            System.out.println(quantidadeAssentos + " assentos estão disponíveis.");
        } else {
            System.out.println("Não há assentos disponíveis.");
        }
    }

    public void realizarPagamento(String tipoViagem, boolean pontosTuristicos) {
        this.tipo = tipoViagem;
        System.out.println("Tipo de viagem: " + tipoViagem + " registrado com sucesso.");
        if(pontosTuristicos){
            this.pontosTuristicos = true;
            System.out.println("Pontos turísticos serão inclusos, aplicando uma taxa adicional.");
        }
    }

    public void imprimirPassagem() {
        System.out.println("Voo " + numeroVoo + " >" +
                " Origem: " + origem +
                " | Destino: " + destino +
                " | Tipo de voo: " + tipo +
                " | Pontos turísticos inclusos?: " + (pontosTuristicos ? "Sim" : "Não") +
                " | Assentos disponíveis: " + assentosDisponiveis);
    }

    @Override
    public String toString() {
        return "Voo " + numeroVoo + " >" +
                " Origem: " + origem +
                " | Destino: " + destino +
                " | Tipo de voo: " + tipo +
                " | Pontos turísticos inclusos?: " + (pontosTuristicos ? "Sim" : "Não") +
                " | Assentos disponíveis: " + assentosDisponiveis;
    }
}
