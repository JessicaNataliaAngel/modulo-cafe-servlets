========================================================================
MÓDULO WEB DE GESTIÓN DE PRODUCTOS DE CAFÉ (SERVLETS + JSP + JDBC)
Evidencia: GA7-220501096-AA2-EV02
Aprendiz: Jessica Natalia Ángel
========================================================================

1. REQUISITOS PREVIOS
- Java JDK 17 o superior.
- Servidor Web Apache Tomcat 11.0.27 (compatible con jakarta.servlet.*).
- Motor de base de datos MariaDB en ejecución en 127.0.0.1:3306.
- Controlador JDBC: mariadb-java-client-4.0.0.jar (incluido en webapp/WEB-INF/lib).

2. CONFIGURACIÓN DE LA BASE DE DATOS
Paso 1: Abra su gestor de base de datos (HeidiSQL, DBeaver o phpMyAdmin).
Paso 2: Ejecute el script ubicado en: sql/script_cafe.sql
        Este script creará la base de datos "cafe_nueva_prueba", la tabla "productos"
        y cargará 4 registros iniciales de prueba.
Paso 3: Verifique en src/Conexion.java y src/ProductoServlet.java que las credenciales
        coincidan con su servidor local (por defecto USUARIO = "root", PASSWORD = "").

3. DESPLIEGUE Y EJECUCIÓN EN APACHE TOMCAT 11
Paso 1: Copie la carpeta "webapp" dentro del directorio "webapps" de Apache Tomcat 11
        (o despliéguela en modo Exploded desde Visual Studio Code).
Paso 2: Inicie el servidor Apache Tomcat 11.
Paso 3: Abra su navegador e ingrese a:
        http://localhost:8080/webapp/index.jsp

4. FUNCIONALIDADES DEL MÓDULO WEB
- Registro de café (POST): Formulario en index.jsp que envía datos a ProductoServlet.
- Consulta de cafés (GET): Enlace en index.jsp que consulta ProductoServlet y muestra
  la tabla dinámica en listar.jsp.
========================================================================
