package com.tienda.config;
import com.tienda.domain.*;
import com.tienda.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
@Configuration
public class DatosDemostracion {
 @Bean CommandLineRunner crearDatos(CategoriaService cs,ProductoService ps){
  return args->{
   var c1=cs.guardar(new Categoria(null,"Computadoras",true,""));
   var c2=cs.guardar(new Categoria(null,"Accesorios",true,""));
   var c3=cs.guardar(new Categoria(null,"Celulares",true,""));
   ps.guardar(new Producto(null,"Laptop para estudiantes",new BigDecimal("325000"),5,c1.getIdCategoria(),true,""));
   ps.guardar(new Producto(null,"Mouse inalámbrico",new BigDecimal("8500"),18,c2.getIdCategoria(),true,""));
   ps.guardar(new Producto(null,"Teléfono inteligente",new BigDecimal("145000"),7,c3.getIdCategoria(),true,""));
  };
 }
}
