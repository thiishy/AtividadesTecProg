package br.universidade.loja.dto;

import java.time.LocalDateTime;

public record EstoqueResponseDTO(Integer quantidadeTotal, LocalDateTime timestamp) { }
