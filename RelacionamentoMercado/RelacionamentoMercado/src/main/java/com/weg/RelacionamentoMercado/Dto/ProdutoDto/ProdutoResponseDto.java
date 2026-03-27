package com.weg.RelacionamentoMercado.Dto.ProdutoDto;

import java.util.UUID;

public record ProdutoResponseDto(
        UUID id,
        String nome,
        double preco
) {
}
