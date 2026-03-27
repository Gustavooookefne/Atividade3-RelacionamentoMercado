package com.weg.RelacionamentoMercado.mapper;

import com.weg.RelacionamentoMercado.Dto.ProdutoDto.ProdutoRequestDto;
import com.weg.RelacionamentoMercado.Dto.ProdutoDto.ProdutoResponseDto;
import com.weg.RelacionamentoMercado.model.Produto;

public class ProdutoMapper {

    public Produto paraEntidade (ProdutoRequestDto requestDto) {
        return new Produto(
                requestDto.nome(),
                requestDto.preco(),
                requestDto.idCategoria()
        );
    }

    public ProdutoResponseDto paraDto (Produto produto) {
        return new ProdutoResponseDto(
                produto.getId(),
                produto.getNome(),
                produto.getPreco()
        );
    }
}
