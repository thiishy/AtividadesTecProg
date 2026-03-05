package br.edu.fatecpg.restaurante.view;
import br.edu.fatecpg.restaurante.model.Pedido;
import br.edu.fatecpg.restaurante.model.ItemPedido;
import br.edu.fatecpg.restaurante.model.Restaurante;

public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido(150);
        ItemPedido item1 = new ItemPedido("Strogonoff", 2, 4);
        ItemPedido item2 = new ItemPedido("Parmegiana", 3, 5);
        Restaurante restaurante = new Restaurante();

        pedido1.adicionarItem(item1);
        pedido1.adicionarItem(item2);
        pedido1.reservarMesa(30);
        System.out.println("Total do pedido: R$" + pedido1.calcularTotalPedido());
        restaurante.adicionarPedido(pedido1);
        System.out.println(restaurante.buscarPedido(150));
    }
}
