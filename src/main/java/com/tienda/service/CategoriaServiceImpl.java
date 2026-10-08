package com.tienda.service;
import com.tienda.domain.Categoria;
import com.tienda.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CategoriaServiceImpl implements CategoriaService {
 private final CategoriaRepository repository;
 private final ProductoRepository productos;
 public CategoriaServiceImpl(CategoriaRepository repository,ProductoRepository productos){this.repository=repository;this.productos=productos;}
 public List<Categoria> getCategorias(){return repository.findAll();}
 public Categoria getCategoria(Long id){return repository.findById(id).orElseThrow(()->new IllegalArgumentException("Categoría no encontrada"));}
 public Categoria guardar(Categoria categoria){return repository.save(categoria);}
 public void eliminar(Long id){
  if(productos.existsByIdCategoria(id))throw new IllegalStateException("No se puede eliminar una categoría que tiene productos asociados.");
  repository.deleteById(id);
 }
}
