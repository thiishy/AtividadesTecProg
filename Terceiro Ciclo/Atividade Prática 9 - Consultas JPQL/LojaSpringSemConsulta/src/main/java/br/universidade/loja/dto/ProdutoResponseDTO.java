package br.universidade.loja.dto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(Long id, String nome, BigDecimal preco) { }
