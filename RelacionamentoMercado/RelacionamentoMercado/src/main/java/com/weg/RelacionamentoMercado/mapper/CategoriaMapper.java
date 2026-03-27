package com.weg.RelacionamentoMercado.mapper;

import com.weg.RelacionamentoMercado.Dto.CategoriaDto.CategoriaRequestDto;
import com.weg.RelacionamentoMercado.Dto.CategoriaDto.CategoriaResponseDto;
import com.weg.RelacionamentoMercado.model.Categoria;

public class CategoriaMapper {

    public Categoria paraEntidades (CategoriaRequestDto requestDto) {
        return new Categoria(
                requestDto.nomeCategoria()
        );
    }

    public CategoriaResponseDto paraDto (Categoria categoria) {
        return new CategoriaResponseDto(
                categoria.getId(),
                categoria.getNomeCategoria()
        );
    }
}
