package br.edu.fatecpg.restaurante.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Pedido> pedidos = new ArrayList<>();

    public String getPedidos() {
        return pedidos.toString();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido " + pedido.getNumero() + " adicionado com sucesso!");
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
        System.out.println("Pedido " + pedido.getNumero() + " removido com sucesso!");
    }

    public Pedido buscarPedido(int numeroPedido) {
        return pedidos.stream().filter(p -> p.getNumero() == numeroPedido).findFirst().orElse(null);
    }
}
