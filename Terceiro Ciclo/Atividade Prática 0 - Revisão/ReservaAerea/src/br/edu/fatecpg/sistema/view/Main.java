package br.edu.fatecpg.sistema.view;
import br.edu.fatecpg.sistema.model.Voo;
import br.edu.fatecpg.sistema.model.Aeroporto;

public class Main {
    public static void main(String[] args) {
        Voo voo1 = new Voo("ABC123", "Algumlugar", 100, "Lugarquestou");
        Aeroporto aeroporto = new Aeroporto();

        voo1.realizarReserva(50);
        voo1.realizarPagamento("Ida e volta", true);

        aeroporto.adicionarVoo(voo1);
        System.out.println(aeroporto.buscarVoo("ABC123"));
    }
}
