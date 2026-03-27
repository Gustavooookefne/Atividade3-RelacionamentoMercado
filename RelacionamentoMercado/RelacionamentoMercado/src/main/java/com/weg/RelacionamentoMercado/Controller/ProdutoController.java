package com.weg.RelacionamentoMercado.Controller;

import com.weg.RelacionamentoMercado.Dto.ProdutoDto.ProdutoRequestDto;
import com.weg.RelacionamentoMercado.Dto.ProdutoDto.ProdutoResponseDto;
import com.weg.RelacionamentoMercado.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService service;

    @PutMapping
    public ProdutoResponseDto salvar (@RequestBody ProdutoRequestDto requestDto) {
        return service.salvar(requestDto);
    }

    @GetMapping
    public List<ProdutoResponseDto> listarTodos () {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProdutoResponseDto listarPorId (@PathVariable UUID id) {
        return service.listarPorId(id);
    }

    @PostMapping("/{id}")
    public ProdutoResponseDto atualizar (@RequestBody ProdutoRequestDto requestDto ,@PathVariable UUID id) {
        return service.atualizar(requestDto , id);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable UUID id) {
        service.deletar(id);
    }
}
