package com.weg.RelacionamentoMercado.repository;

import com.weg.RelacionamentoMercado.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria , Long> {
}
