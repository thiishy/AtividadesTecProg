package br.edu.fatecpg.restaurante.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private List<ItemPedido> itens = new ArrayList<>();
    private boolean[] mesas = new boolean[100];
    private List<Integer> mesasReservadas = new ArrayList<>();

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getNumero() {
        return numeroPedido;
    }

    public void setNumero(int numero) {
        this.numeroPedido = numero;
    }

    public double calcularTotalPedido(){
        double totalPedido = itens.stream().mapToDouble(i ->  i.getPrecoUnitario() * i.getQuantidade()).sum();
        return totalPedido;
    }

    public void adicionarItem(ItemPedido item){
        itens.add(item);
        System.out.println("Item " + item.getNomeDoPrato() + " adicionado com sucesso!");
    }

    public void removerItem(ItemPedido item){
        itens.remove(item);
        System.out.println("Item " + item.getNomeDoPrato() + " removido com sucesso!");
    }

    public void reservarMesa(int numeroMesa){
        if (!mesas[numeroMesa]){
            this.mesas[numeroMesa] = true;
            mesasReservadas.add(numeroMesa);
            System.out.println("Mesa reservada com sucesso!");
        } else {
            System.out.println("A mesa já está reservada.");
        }
    }

    @Override
    public String toString() {
        return "Pedido " + numeroPedido + " > " +
                " | Itens: " + itens +
                " | Mesas reservadas: " + mesasReservadas.toString();
    }
}
