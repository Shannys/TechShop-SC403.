package com.tienda.controller;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/categoria")
public class CategoriaController {
 private final CategoriaService service;
 public CategoriaController(CategoriaService service){this.service=service;}
 @GetMapping("/listado")public String listado(Model m){m.addAttribute("categorias",service.getCategorias());return "categoria/listado";}
 @GetMapping("/nuevo")public String nuevo(Model m){m.addAttribute("categoria",new Categoria());return "categoria/modifica";}
 @GetMapping("/modifica/{id}")public String modifica(@PathVariable Long id,Model m){m.addAttribute("categoria",service.getCategoria(id));return "categoria/modifica";}
 @PostMapping("/guardar")public String guardar(@Valid @ModelAttribute("categoria") Categoria c,BindingResult errors,RedirectAttributes flash){
  if(errors.hasErrors())return "categoria/modifica";
  service.guardar(c);flash.addFlashAttribute("mensaje","Categoría guardada correctamente");return "redirect:/categoria/listado";
 }
 @PostMapping("/eliminar/{id}")public String eliminar(@PathVariable Long id,RedirectAttributes flash){
  try{service.eliminar(id);flash.addFlashAttribute("mensaje","Categoría eliminada");}
  catch(IllegalStateException ex){flash.addFlashAttribute("error",ex.getMessage());}
  return "redirect:/categoria/listado";
 }
}
