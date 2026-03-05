package br.universidade.loja.controller;

import br.universidade.loja.dto.EstoqueResponseDTO;
import br.universidade.loja.dto.ProdutoRequestDTO;
import br.universidade.loja.dto.ProdutoResponseDTO;
import br.universidade.loja.service.LojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/")
public class LojaController {
    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @GetMapping("/produtos/filtrar")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarPorNomeCategoriaPrecoMenor(@RequestBody ProdutoRequestDTO produtoRequestDto) {
        List<ProdutoResponseDTO> listaProdutosDto = lojaService.buscarPorNomeCategoriaPrecoMenor(produtoRequestDto);
        return ResponseEntity.ok().body(listaProdutosDto);
    }

    @GetMapping("/estoque/quantidade")
    public ResponseEntity<EstoqueResponseDTO> getQuantidadeTotalEstoque() {
        EstoqueResponseDTO estoqueResponseDTO = lojaService.getQuantidadeTotalEstoque();
        return ResponseEntity.ok().body(estoqueResponseDTO);
    }
}
