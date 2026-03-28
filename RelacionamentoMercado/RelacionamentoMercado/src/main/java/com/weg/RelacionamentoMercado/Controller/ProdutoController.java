package com.weg.RelacionamentoMercado.Controller;

import com.weg.RelacionamentoMercado.Dto.ProdutoDto.ProdutoRequestDto;
import com.weg.RelacionamentoMercado.Dto.ProdutoDto.ProdutoResponseDto;
import com.weg.RelacionamentoMercado.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService service;

    @PutMapping
    public ResponseEntity<ProdutoResponseDto> salvar (@RequestBody ProdutoRequestDto requestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> listarTodos () {
            List<ProdutoResponseDto> responseDtos = new ArrayList<>();

        return ResponseEntity.ok().body(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> listarPorId (@PathVariable UUID id) {
            ProdutoResponseDto responseDto = service.listarPorId(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> atualizar (@RequestBody ProdutoRequestDto requestDto ,@PathVariable UUID id) {
            ProdutoResponseDto responseDto = service.atualizar(requestDto , id);
        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable UUID id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
