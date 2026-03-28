package com.weg.RelacionamentoMercado.Controller;

import com.weg.RelacionamentoMercado.Dto.CategoriaDto.CategoriaRequestDto;
import com.weg.RelacionamentoMercado.Dto.CategoriaDto.CategoriaResponseDto;
import com.weg.RelacionamentoMercado.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService service;

    @PutMapping
    public ResponseEntity<CategoriaResponseDto> salvar (@RequestBody CategoriaRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDto>> listarTodos () {
            List<CategoriaResponseDto> responseDtos = service.listarTodos();
        return ResponseEntity.ok().body(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> listarPorId (@PathVariable Long id) {
            CategoriaResponseDto responseDto = service.listarPorId(id);

        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> atualizar (@RequestBody CategoriaRequestDto requestDto , @PathVariable Long id) {
            CategoriaResponseDto responseDto = service.atualizar(requestDto , id);

        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
