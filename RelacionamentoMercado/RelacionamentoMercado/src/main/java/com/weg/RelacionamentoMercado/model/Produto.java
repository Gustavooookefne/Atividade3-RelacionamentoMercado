package com.weg.RelacionamentoMercado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @Column(name = "Preço_produto", nullable = false)
    private double preco;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    public Produto(String nome, double preco, Long aLong) {
    }

    public void setCategoria(Long aLong) {
    }
}
