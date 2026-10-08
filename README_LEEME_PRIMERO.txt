TIENDA TECHSHOP — PROYECTO SC403, SEMANAS 1 A 5
=================================================
PARA ABRIR EN NETBEANS
1. Extrae el archivo ZIP (no abras el proyecto dentro del ZIP).
2. Abre Apache NetBeans.
3. Ve a Archivo > Abrir proyecto (File > Open Project).
4. Selecciona la carpeta Tienda_Semanas_1_a_5_NetBeans (la que contiene pom.xml).
5. Espera a que NetBeans descargue las dependencias Maven. Necesita internet la primera vez.
6. Verifica que tengas JDK 17 o 21 seleccionado.
7. En Projects, clic derecho sobre 'tienda' > Run.
   Si NetBeans pregunta por la clase principal, elige com.tienda.TiendaApplication.
8. Abre http://localhost:8080

RUTAS
Inicio:      http://localhost:8080/
Categorías:  http://localhost:8080/categoria/listado
Productos:   http://localhost:8080/producto/listado

¿QUÉ INCLUYE?
Semana 1: Spring Boot, HTML, controlador, vista y flujo MVC.
Semana 2: Bootstrap, fragmentos head/header/footer, internacionalización ES/EN.
Semana 3: capas domain / repository / service / controller; gestión de categorías.
Semana 4: CRUD completo de categorías (crear, listar, editar, eliminar).
Semana 5: CRUD de productos y relación con categorías, validaciones.

IMPORTANTE: ESTA VERSIÓN FUNCIONA SIN SQL
* Los datos viven en memoria; al cerrar y volver a abrir la aplicación se restauran los
  datos de ejemplo y se pierden las modificaciones.
* NO incluye conexión a MySQL (se añadirá después, como solicitaste).
* NO incluye Firebase Storage activo: el tema se explica en semana 4, pero usarlo
  exige crear un proyecto en Firebase y configurar credenciales propias.
  Por ahora se pueden guardar URLs de imágenes.
* Bootstrap se carga desde CDN, por lo que su estilo necesita conexión a internet.
* Si el puerto 8080 está ocupado, cambia server.port en application.properties.

ESTRUCTURA
src/main/java/com/tienda/
  TiendaApplication.java
  controller/       Controladores de inicio, categoría y producto
  domain/           Clases Categoria y Producto
  repository/       Contratos y repositorios temporales en memoria
  service/          Servicios e implementación
  config/           Registros de demostración
src/main/resources/
  templates/        Thymeleaf (general, categoria, producto e index)
  static/css/       Estilos
  application.properties
  messages.properties y messages_en.properties

NOTA: Proyecto elaborado como recreación didáctica basada en las diapositivas
suministradas, no como copia exacta del código docente (no se proporcionaron
los archivos fuente de clase).

CORRECCIÓN NETBEANS: nbactions.xml configura Run con spring-boot:run, y pom.xml define explicitamente la clase principal.
