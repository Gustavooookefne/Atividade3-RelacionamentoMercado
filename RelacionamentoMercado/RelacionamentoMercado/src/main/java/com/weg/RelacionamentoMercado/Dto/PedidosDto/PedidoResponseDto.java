package com.weg.RelacionamentoMercado.Dto.PedidosDto;

import java.util.UUID;

public record PedidoResponseDto (
        UUID id,
        String nome,
        double preco
) {
}
