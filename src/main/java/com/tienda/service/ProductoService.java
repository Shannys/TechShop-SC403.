package com.tienda.service;
import com.tienda.domain.Producto;
import java.util.*;
public interface ProductoService {
 List<Producto> getProductos();
 Producto getProducto(Long id);
 Producto guardar(Producto producto);
 void eliminar(Long id);
}
