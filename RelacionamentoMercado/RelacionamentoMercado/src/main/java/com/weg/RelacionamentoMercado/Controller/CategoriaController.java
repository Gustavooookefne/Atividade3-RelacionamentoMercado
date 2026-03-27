package com.weg.RelacionamentoMercado.Controller;

import com.weg.RelacionamentoMercado.Dto.CategoriaDto.CategoriaRequestDto;
import com.weg.RelacionamentoMercado.Dto.CategoriaDto.CategoriaResponseDto;
import com.weg.RelacionamentoMercado.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService service;

    @PutMapping
    public CategoriaResponseDto salvar (@RequestBody CategoriaRequestDto requestDto) {
        return service.salvar(requestDto);
    }

    @GetMapping
    public List<CategoriaResponseDto> listarTodos () {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaResponseDto listarPorId (@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @PostMapping("/{id}")
    public CategoriaResponseDto atualizar (@RequestBody CategoriaRequestDto requestDto , @PathVariable Long id) {
        return service.atualizar(requestDto , id);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Long id) {
        service.deletar(id);
    }
}
