package br.com.fiap.pharmaeasetotem.record;

import jakarta.validation.constraints.NotBlank;

public record PedidoRecord (
        @NotBlank
        Long remedioId,
        @NotBlank
        int quantidade
) { }
