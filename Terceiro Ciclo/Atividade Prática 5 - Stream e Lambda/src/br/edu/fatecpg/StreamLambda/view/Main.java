package br.edu.fatecpg.StreamLambda.view;

import br.edu.fatecpg.StreamLambda.model.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Produto> lista = List.of(
                new Produto("Fone de Ouvido Bluetooth", "Eletrônicos", 249.90),
                new Produto("Smartwatch", "Eletrônicos", 399.00),
                new Produto("Caixa de Som Portátil", "Eletrônicos", 179.90),
                new Produto("Camiseta Oversized", "Roupas", 79.90),
                new Produto("Jaqueta Corta-Vento", "Roupas", 189.00)
        );

        List<Produto> eletronicosComDesconto = lista.stream()
                                    .filter(p -> "Eletrônicos".equals(p.getCategoria()))
                                    .map(p -> new Produto(p.getNome(), p.getCategoria(), p.getPreco() * 0.9))
                                    .sorted(Comparator.comparingDouble(Produto::getPreco))
                                    .toList();

        Double totalRoupas = lista.stream()
                        .filter(p -> "Roupas".equals(p.getCategoria()))
                        .map(Produto::getPreco)
                        .reduce(0.0, Double::sum);

        Map<String, Double> mediaPorCategoria = lista.stream()
                                                .collect(Collectors.groupingBy(
                                                        Produto::getCategoria,
                                                        Collectors.averagingDouble(Produto::getPreco)
                                                ));

        StringBuilder sb = new StringBuilder();
        sb.append("------- Eletrônicos com desconto de 10% (ordem crescente) --------\n");
        eletronicosComDesconto.forEach(p -> {
            sb.append("- Nome: ").append(p.getNome())
                    .append(" | Preço: R$").append(String.format("%.2f", p.getPreco()))
                    .append(" | Categoria: ").append(p.getCategoria())
                    .append("\n");
        });
        sb.append("------------------------------------------------------------------\n");

        sb.append("Total gasto em roupas: R$").append(String.format("%.2f", totalRoupas)).append("\n");

        sb.append("----------------- Média de preço por categoria -------------------\n");
        mediaPorCategoria.forEach((categoria, media) ->
                sb.append(categoria)
                        .append(": média = R$")
                        .append(String.format("%.2f", media))
                        .append("\n")
        );

        sb.append("------------------------------------------------------------------\n");

        System.out.println(sb.toString());
    }
}
