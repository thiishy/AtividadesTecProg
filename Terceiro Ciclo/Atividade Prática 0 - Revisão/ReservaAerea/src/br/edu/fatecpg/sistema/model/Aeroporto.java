package br.edu.fatecpg.sistema.model;

import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
    private List<Voo> voos = new ArrayList<>();

    public String getVoos() {
        return voos.toString();
    }

    public void adicionarVoo(Voo voo) {
        voos.add(voo);
        System.out.println("Voo " + voo.getNumeroVoo() + " adicionado com sucesso!");
    }

    public void removerVoo(Voo voo) {
        voos.remove(voo);
        System.out.println("Voo " + voo.getNumeroVoo() + " removido com sucesso!");
    }

    public Voo buscarVoo(String numeroVoo) {
        return voos.stream().filter(v -> v.getNumeroVoo().equals(numeroVoo)).findFirst().orElse(null);
    }
}
