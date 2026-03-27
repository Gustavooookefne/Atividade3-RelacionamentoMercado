package com.weg.RelacionamentoMercado.Dto.PedidosDto;

public record PedidoRequestDto (
       String nome,
       double preco,
       Long idCategoria
) {
}
