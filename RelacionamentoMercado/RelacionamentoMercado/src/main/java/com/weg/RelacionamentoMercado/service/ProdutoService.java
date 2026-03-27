package com.weg.RelacionamentoMercado.service;

import com.weg.RelacionamentoMercado.Dto.ProdutoDto.ProdutoRequestDto;
import com.weg.RelacionamentoMercado.Dto.ProdutoDto.ProdutoResponseDto;
import com.weg.RelacionamentoMercado.mapper.ProdutoMapper;
import com.weg.RelacionamentoMercado.model.Produto;
import com.weg.RelacionamentoMercado.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoResponseDto salvar (ProdutoRequestDto requestDto) {
        Produto produto = new Produto();
        return mapper.paraDto(repository.save(produto));
    }

    public List<ProdutoResponseDto> listarTodos () {
        return repository.findAll()
                .stream()
                .map(mapper::paraDto)
                .toList();
    }

    public ProdutoResponseDto listarPorId (UUID id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        return mapper.paraDto(produto);
    }

    public ProdutoResponseDto atualizar (ProdutoRequestDto requestDto ,UUID id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(requestDto.nome());
        produto.setCategoria(requestDto.idCategoria());
        produto.setPreco(requestDto.preco());

        return mapper.paraDto(produto);

    }

    public void deletar (UUID id) {
        repository.deleteById(id);
    }
}
