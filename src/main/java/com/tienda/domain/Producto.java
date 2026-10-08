package com.tienda.domain;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
public class Producto {
 private Long idProducto;
 @NotBlank(message="La descripción es obligatoria")
 @Size(max=100)
 private String descripcion;
 @NotNull(message="El precio es obligatorio") @DecimalMin(value="0.01",message="Debe ser mayor que cero")
 private BigDecimal precio;
 @NotNull(message="Indique las existencias") @Min(value=0,message="No puede ser negativo")
 private Integer existencias;
 @NotNull(message="Seleccione una categoría")
 private Long idCategoria;
 private boolean activo=true;
 private String rutaImagen;
 public Producto(){}
 public Producto(Long id,String descripcion,BigDecimal precio,Integer existencias,Long categoria,boolean activo,String rutaImagen){
  this.idProducto=id;this.descripcion=descripcion;this.precio=precio;this.existencias=existencias;this.idCategoria=categoria;this.activo=activo;this.rutaImagen=rutaImagen;
 }
 public Long getIdProducto(){return idProducto;} public void setIdProducto(Long x){idProducto=x;}
 public String getDescripcion(){return descripcion;} public void setDescripcion(String x){descripcion=x;}
 public BigDecimal getPrecio(){return precio;} public void setPrecio(BigDecimal x){precio=x;}
 public Integer getExistencias(){return existencias;} public void setExistencias(Integer x){existencias=x;}
 public Long getIdCategoria(){return idCategoria;} public void setIdCategoria(Long x){idCategoria=x;}
 public boolean isActivo(){return activo;} public void setActivo(boolean x){activo=x;}
 public String getRutaImagen(){return rutaImagen;} public void setRutaImagen(String x){rutaImagen=x;}
}
