package com.tienda.service;
import com.tienda.domain.Categoria;
import java.util.*;
public interface CategoriaService {
 List<Categoria> getCategorias();
 Categoria getCategoria(Long id);
 Categoria guardar(Categoria categoria);
 void eliminar(Long id);
}
