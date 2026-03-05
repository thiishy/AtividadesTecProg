package br.universidade.loja;

import br.universidade.loja.model.Categoria;
import br.universidade.loja.model.Estoque;
import br.universidade.loja.model.Produto;
import br.universidade.loja.repository.CategoriaRepository;
import br.universidade.loja.repository.EstoqueRepository;
import br.universidade.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LojaApplication implements CommandLineRunner {
    /*
	private final CategoriaRepository catRepo;
	private final ProdutoRepository prodRepo;
	private final EstoqueRepository estRepo;

    public LojaApplication(CategoriaRepository catRepo, ProdutoRepository prodRepo, EstoqueRepository estRepo) {
        this.catRepo = catRepo;
        this.prodRepo = prodRepo;
        this.estRepo = estRepo;
    }
    */

    public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
        System.out.println("Loja inicializada!\n");

        /*
        // Criação das categorias
        Categoria informatica = new Categoria("Informática");
        Categoria perifericos = new Categoria("Periféricos");
        Categoria acessorios = new Categoria("Acessórios");
        catRepo.saveAll(Arrays.asList(informatica, perifericos, acessorios));

        // Criação dos produtos
        Produto notebook = new Produto("Notebook Dell Inspiron 15", new
                BigDecimal("3500.00"), informatica);
        Produto impressora = new Produto("Impressora HP LaserJet Pro M404n", new
                BigDecimal("1200.00"), perifericos);
        Produto monitor = new Produto("Monitor LG UltraWide 29", new
                BigDecimal("1800.00"), perifericos);
        Produto teclado = new Produto("Teclado Mecânico Corsair K95", new
                BigDecimal("900.00"), acessorios);
        Produto mouse = new Produto("Mouse Logitech MX Master 3", new
                BigDecimal("600.00"), acessorios);
        prodRepo.saveAll(Arrays.asList(notebook, impressora, monitor, teclado,
                mouse));

        // Criação dos estoques
        Estoque estoqueNotebook = new Estoque(notebook, 15);
        Estoque estoqueImpressora = new Estoque(impressora, 10);
        Estoque estoqueMonitor = new Estoque(monitor, 8);
        Estoque estoqueTeclado = new Estoque(teclado, 20);
        Estoque estoqueMouse = new Estoque(mouse, 25);
        estRepo.saveAll(Arrays.asList(estoqueNotebook, estoqueImpressora,
                        estoqueMonitor, estoqueTeclado, estoqueMouse);
        */


       /*
       List<Produto> lista = prodRepo.findByCategoriaNomeAndPrecoLessThan("Informática", new BigDecimal("3600.00"));
       StringBuilder sb = new StringBuilder();
       sb.append("---------- Produtos da categoria Informática com preço menor que 3600.00 ----------\n");
       for (Produto prod : lista) {
          sb.append(prod.getNome()).append("\n");
       }
       sb.append("-----------------------------------------------------------------------------------\n");

       Integer quantidadeTotal = estRepo.findTotalItensEmEstoque();
       sb.append("Quantidade total de produtos em estoque: ").append(quantidadeTotal);
       System.out.println(sb);
       */
    }

}
