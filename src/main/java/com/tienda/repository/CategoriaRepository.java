package com.tienda.repository;
import com.tienda.domain.Categoria;
import java.util.*;
public interface CategoriaRepository {
 List<Categoria> findAll();
 Optional<Categoria> findById(Long id);
 Categoria save(Categoria categoria);
 void deleteById(Long id);
}
