package com.tienda.controller;
import com.tienda.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class InicioController {
 private final CategoriaService categorias;
 private final ProductoService productos;
 public InicioController(CategoriaService cs,ProductoService ps){categorias=cs;productos=ps;}
 @GetMapping({"/","/index"})
 public String inicio(Model model){model.addAttribute("categorias",categorias.getCategorias());model.addAttribute("productos",productos.getProductos().stream().filter(p->p.isActivo()).toList());return "index";}
}
