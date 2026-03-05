package br.universidade.loja.service;

import br.universidade.loja.dto.EstoqueResponseDTO;
import br.universidade.loja.dto.ProdutoRequestDTO;
import br.universidade.loja.dto.ProdutoResponseDTO;
import br.universidade.loja.repository.EstoqueRepository;
import br.universidade.loja.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LojaService {
    private final EstoqueRepository estRepo;
    private final ProdutoRepository prodRepo;

    public LojaService(EstoqueRepository estRepo, ProdutoRepository prodRepo) {
        this.estRepo = estRepo;
        this.prodRepo = prodRepo;
    }

    public List<ProdutoResponseDTO> buscarPorNomeCategoriaPrecoMenor(ProdutoRequestDTO produtoRequestDto) {
        return prodRepo.findByCategoriaNomeAndPrecoLessThan(produtoRequestDto.nomeCategoria(), produtoRequestDto.precoMenorQue())
                .stream()
                .map(p -> new ProdutoResponseDTO(p.getId(), p.getNome(), p.getPreco()))
                .toList();
    }

    public EstoqueResponseDTO getQuantidadeTotalEstoque() {
        Integer quantidadeTotal = estRepo.findTotalItensEmEstoque();
        return new EstoqueResponseDTO(quantidadeTotal, LocalDateTime.now());
    }
}
