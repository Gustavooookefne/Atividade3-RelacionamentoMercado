package com.weg.RelacionamentoMercado.service;

import com.weg.RelacionamentoMercado.Dto.CategoriaDto.CategoriaRequestDto;
import com.weg.RelacionamentoMercado.Dto.CategoriaDto.CategoriaResponseDto;
import com.weg.RelacionamentoMercado.mapper.CategoriaMapper;
import com.weg.RelacionamentoMercado.model.Categoria;
import com.weg.RelacionamentoMercado.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaResponseDto salvar (CategoriaRequestDto requestDto) {

        Categoria categoria = new Categoria();

        return mapper.paraDto(repository.save(categoria));
    }

    public List<CategoriaResponseDto> listarTodos () {
        return repository.findAll()
                .stream()
                .map(mapper::paraDto)
                .toList();
    }

    public CategoriaResponseDto listarPorId (Long id) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        return mapper.paraDto(categoria);
    }

    public CategoriaResponseDto atualizar (CategoriaRequestDto requestDto , Long id) {
        Categoria categoria =  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoria.getNomeCategoria();

        return mapper.paraDto(categoria);
    }

    public void deletar (Long id) {
        repository.deleteById(id);
    }
}
