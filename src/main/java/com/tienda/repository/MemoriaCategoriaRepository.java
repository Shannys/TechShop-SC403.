package com.tienda.repository;
import com.tienda.domain.Categoria;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class MemoriaCategoriaRepository implements CategoriaRepository {
 private final Map<Long,Categoria> registros=new ConcurrentHashMap<>();
 private final AtomicLong secuencia=new AtomicLong();
 public List<Categoria> findAll(){return registros.values().stream().sorted(Comparator.comparing(Categoria::getIdCategoria)).toList();}
 public Optional<Categoria> findById(Long id){return Optional.ofNullable(registros.get(id));}
 public synchronized Categoria save(Categoria c){if(c.getIdCategoria()==null)c.setIdCategoria(secuencia.incrementAndGet());registros.put(c.getIdCategoria(),c);return c;}
 public void deleteById(Long id){registros.remove(id);}
}
