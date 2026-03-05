package br.edu.fatecpg.consomeapi.view;
import br.edu.fatecpg.consomeapi.model.Endereco;
import br.edu.fatecpg.consomeapi.service.BuscaEndereco;
import br.edu.fatecpg.consomeapi.controller.BancoController;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.Scanner;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean menu = true;
        BuscaEndereco bE = new BuscaEndereco();
        BancoController bC = new BancoController();
        Gson gson = new Gson();

        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("[1] Buscar Endereço");
            System.out.println("[2] Mostrar todos os endereços salvos no banco");
            System.out.println("[3] Inserir CEP");
            System.out.println("[4] Sair");
            System.out.println("Digite a opção: ");
            String escolha = scan.nextLine();

            switch(Integer.parseInt(escolha)){
                case 1:
                    System.out.println("Digite o ID: ");
                    String id = scan.nextLine();
                    System.out.println(bC.selecionarEndereco(Integer.parseInt(id)));
                    break;

                case 2:
                    System.out.println(bC.selecionarTodosEnderecos());
                    break;

                case 3:
                    System.out.println("Digite o CEP: ");
                    String cepEscolhido = scan.nextLine();
                    try {
                        String end = bE.obterEndereco(cepEscolhido);
                        Endereco novoEnd = gson.fromJson(end, Endereco.class);
                        System.out.println("Endereço: " + novoEnd);

                        System.out.println("Deseja inserir no banco? S/N (padrão é N): ");
                        String sn = scan.nextLine();

                        switch(sn){
                            case "S":
                                System.out.println(bC.inserirEndereco(novoEnd.getCep(), novoEnd.getRua(), novoEnd.getBairro(), novoEnd.getLocalidade(), novoEnd.getEstado()));
                                break;

                            case "N":
                                break;

                            default:
                                break;
                        }

                    } catch(JsonSyntaxException e) {
                        System.out.println("CEP inválido ou inexistente.");
                    }
                    break;

                case 4:
                    menu = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while(menu);
    }
}
