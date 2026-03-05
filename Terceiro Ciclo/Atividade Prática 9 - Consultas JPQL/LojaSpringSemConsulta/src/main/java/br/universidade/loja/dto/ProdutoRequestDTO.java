package br.universidade.loja.dto;

import java.math.BigDecimal;

public record ProdutoRequestDTO(String nomeCategoria, BigDecimal precoMenorQue) { }
