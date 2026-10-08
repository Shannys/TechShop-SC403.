package com.tienda.controller;
import com.tienda.domain.Producto;
import com.tienda.service.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/producto")
public class ProductoController {
 private final ProductoService service;
 private final CategoriaService categorias;
 public ProductoController(ProductoService service,CategoriaService categorias){this.service=service;this.categorias=categorias;}
 @GetMapping("/listado")public String listado(Model m){m.addAttribute("productos",service.getProductos());m.addAttribute("categorias",categorias.getCategorias());return "producto/listado";}
 @GetMapping("/nuevo")public String nuevo(Model m){m.addAttribute("producto",new Producto());m.addAttribute("categorias",categorias.getCategorias());return "producto/modifica";}
 @GetMapping("/modifica/{id}")public String modifica(@PathVariable Long id,Model m){m.addAttribute("producto",service.getProducto(id));m.addAttribute("categorias",categorias.getCategorias());return "producto/modifica";}
 @PostMapping("/guardar")public String guardar(@Valid @ModelAttribute("producto") Producto producto,BindingResult errors,Model model,RedirectAttributes flash){
  if(errors.hasErrors()){model.addAttribute("categorias",categorias.getCategorias());return "producto/modifica";}
  try{service.guardar(producto);}
  catch(IllegalArgumentException ex){model.addAttribute("categorias",categorias.getCategorias());model.addAttribute("error",ex.getMessage());return "producto/modifica";}
  flash.addFlashAttribute("mensaje","Producto guardado correctamente");return "redirect:/producto/listado";
 }
 @PostMapping("/eliminar/{id}")public String eliminar(@PathVariable Long id,RedirectAttributes flash){service.eliminar(id);flash.addFlashAttribute("mensaje","Producto eliminado");return "redirect:/producto/listado";}
}
