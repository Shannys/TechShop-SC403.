package com.tienda.repository;
import com.tienda.domain.Producto;
import java.util.*;
public interface ProductoRepository {
 List<Producto> findAll();
 Optional<Producto> findById(Long id);
 Producto save(Producto producto);
 void deleteById(Long id);
 boolean existsByIdCategoria(Long id);
}
