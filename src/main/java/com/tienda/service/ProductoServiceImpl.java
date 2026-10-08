package com.tienda.service;
import com.tienda.domain.Producto;
import com.tienda.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ProductoServiceImpl implements ProductoService {
 private final ProductoRepository repository;
 private final CategoriaRepository categorias;
 public ProductoServiceImpl(ProductoRepository repository,CategoriaRepository categorias){this.repository=repository;this.categorias=categorias;}
 public List<Producto> getProductos(){return repository.findAll();}
 public Producto getProducto(Long id){return repository.findById(id).orElseThrow(()->new IllegalArgumentException("Producto no encontrado"));}
 public Producto guardar(Producto producto){
  if(categorias.findById(producto.getIdCategoria()).isEmpty())throw new IllegalArgumentException("Seleccione una categoría válida");
  return repository.save(producto);
 }
 public void eliminar(Long id){repository.deleteById(id);}
}
