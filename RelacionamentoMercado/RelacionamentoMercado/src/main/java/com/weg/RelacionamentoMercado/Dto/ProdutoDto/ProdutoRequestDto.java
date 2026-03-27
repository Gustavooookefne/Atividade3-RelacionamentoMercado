package com.weg.RelacionamentoMercado.Dto.ProdutoDto;

public record ProdutoRequestDto(
       String nome,
       double preco,
       Long idCategoria
) {
}
