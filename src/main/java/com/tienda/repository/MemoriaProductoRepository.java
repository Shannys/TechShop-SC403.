package com.tienda.repository;
import com.tienda.domain.Producto;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class MemoriaProductoRepository implements ProductoRepository {
 private final Map<Long,Producto> registros=new ConcurrentHashMap<>();
 private final AtomicLong secuencia=new AtomicLong();
 public List<Producto> findAll(){return registros.values().stream().sorted(Comparator.comparing(Producto::getIdProducto)).toList();}
 public Optional<Producto> findById(Long id){return Optional.ofNullable(registros.get(id));}
 public synchronized Producto save(Producto p){if(p.getIdProducto()==null)p.setIdProducto(secuencia.incrementAndGet());registros.put(p.getIdProducto(),p);return p;}
 public void deleteById(Long id){registros.remove(id);}
 public boolean existsByIdCategoria(Long id){return registros.values().stream().anyMatch(p->id.equals(p.getIdCategoria()));}
}
