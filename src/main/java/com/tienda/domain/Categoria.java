package com.tienda.domain;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class Categoria {
 private Long idCategoria;
 @NotBlank(message="La descripción es obligatoria")
 @Size(max=50,message="Máximo 50 caracteres")
 private String descripcion;
 private boolean activo=true;
 private String rutaImagen;
 public Categoria(){}
 public Categoria(Long id,String descripcion,boolean activo,String rutaImagen){this.idCategoria=id;this.descripcion=descripcion;this.activo=activo;this.rutaImagen=rutaImagen;}
 public Long getIdCategoria(){return idCategoria;}
 public void setIdCategoria(Long id){this.idCategoria=id;}
 public String getDescripcion(){return descripcion;}
 public void setDescripcion(String descripcion){this.descripcion=descripcion;}
 public boolean isActivo(){return activo;}
 public void setActivo(boolean activo){this.activo=activo;}
 public String getRutaImagen(){return rutaImagen;}
 public void setRutaImagen(String rutaImagen){this.rutaImagen=rutaImagen;}
}
