<img width="1674" height="502" alt="EBOOKPORTADA" src="https://github.com/user-attachments/assets/7e8c546b-eaa7-43ef-babe-12f5b482170b" />

## 📖 Descripción general

Esta **API de Biblioteca Digital** es un sistema completo desarrollado con **Java 17 y Spring Boot** diseñado para modernizar la gestión de bibliotecas. Ofrece un ecosistema robusto que incluye catálogo digital de libros, gestión de usuarios, sistema de préstamos, comentarios y un sistema de recomendaciones mediante likes.

### 🎯 Funcionalidades Principales:
- **Gestión completa de libros** con metadatos detallados (ISBN, editorial, autores, categorías)
- **Sistema de usuarios avanzado** con perfiles, roles y permisos
- **Préstamos** con control de disponibilidad y límites
- **Sistema social** de comentarios y likes para interacción entre usuarios
- **Biblioteca personal** donde usuarios pueden guardar sus libros favoritos
- **Notificaciones automáticas** por email para registros, préstamos y recordatorios
- **Reportes exportables** en Excel para administración y análisis

### 🛠️ Stack Tecnológico:
- **Java 17** + **Spring Boot 3** para el backend
- **Spring Security** + **JWT** para autenticación segura
- **Spring Data JPA** para persistencia de datos
- **MySQL** como base de datos relacional
- **Spring Mail** para notificaciones por email
- **Lombok** para reducción de código boilerplate
- **MapStruct** para mapeo entre entidades y DTOs
- **Apache POI** para generación de reportes en Excel

## ✨ Características
- **Gestión Completa de Libros**: Administra información detallada de libros, autores, categorías y disponibilidad
- **Sistema de Usuarios**: Registro y gestión de usuarios con notificaciones por email
- **Validaciones robustas** en préstamos y reservas
- **Control de Préstamos**: Seguimiento de libros prestados y devoluciones
- **Arquitectura REST**: Diseño basado en principios REST para integración sencilla con respuestas estandarizadas (JsonApiResponse)
- **Notificaciones por Email**: Envío automático de emails para confirmación de registro y notificaciones
- **Reportes en Excel**: Exportación de reportes generales en formato Excel
- **Autenticación JWT**: Sistema seguro de autenticación con tokens JWT
- **JsonApiResponse**: Respuestas estandarizadas para fácil consumo por clientes
- **API documentada**

## 🛠️ Requisitos

- **Java 17**: Asegúrate de instalar la versión correcta del JDK
- **MySQL**: La API utiliza una base de datos MySQL para almacenar y gestionar la información bibliográfica
- **Servicio SMTP**: Configuración de servidor de email para las notificaciones

## 🔍 Funcionamiento de la API

La API de Biblioteca Digital está diseñada para administrar el ciclo completo de gestión bibliotecaria, incluyendo catálogo de libros, sistema de usuarios, comentarios, likes y relaciones complejas entre entidades.

### 🔗 Relaciones:

- **Uno a Muchos (Usuario - Comentarios)**: Un usuario puede realizar múltiples comentarios, pero cada comentario pertenece a un único usuario
- **Uno a Muchos (Libro - Comentarios)**: Un libro puede tener múltiples comentarios, pero cada comentario está asociado a un único libro
- **Muchos a Muchos (Usuario - Libros via Likes)**: Un usuario puede dar like a múltiples libros, y un libro puede recibir likes de múltiples usuarios
- **Muchos a Muchos (Usuario - Roles)**: Un usuario puede tener múltiples roles, y un rol puede ser asignado a múltiples usuarios
- **Muchos a Muchos (Usuario - Libros via Biblioteca)**: Un usuario puede agregar múltiples libros a su biblioteca personal, y un libro puede estar en la biblioteca de múltiples usuarios
- **Muchos a Muchos (Libro - Autores)**: Un libro puede tener múltiples autores, y un autor puede haber escrito múltiples libros
- **Muchos a Muchos (Libro - Categorías)**: Un libro puede pertenecer a múltiples categorías, y una categoría puede contener múltiples libros

### 📊 Estructura Principal:

- **Usuario**: Gestión completa de usuarios con perfil, dirección, teléfono e imagen
- **Libro**: Información detallada de libros incluyendo título, editorial, ISBN, fecha de publicación y sinopsis
- **Autor**: Datos biográficos de autores con nacionalidad, fecha de nacimiento e imagen
- **Categoría**: Organización temática de libros con descripciones
- **Comentario**: Sistema de comentarios de usuarios sobre libros
- **Like**: Funcionalidad de likes para libros favoritos
- **Role**: Sistema de roles y permisos para usuarios

## ♻️ Comportamiento en cascada

La API implementa comportamiento en cascada para mantener la integridad referencial:
- Al eliminar un usuario, se eliminan automáticamente todos sus comentarios, likes y entradas en su biblioteca personal
- Al eliminar un libro, se gestionan en cascada los comentarios, likes y referencias en bibliotecas personales
- La eliminación de autores mantiene la integridad a través de la tabla de relación libro_autor
- El sistema de roles permite asignación flexible sin afectar la información principal de usuarios

Esta funcionalidad garantiza la consistencia de los datos y evita información huérfana en la base de datos, manteniendo las relaciones complejas de manera eficiente.

## 📧 Configuración de Email

El sistema incluye notificaciones automáticas por email para:
- Confirmación de registro exitoso de usuarios
- Recordatorios de préstamos próximos a vencer
- Notificaciones de disponibilidad de libros reservados

## 📊 Generación de Reportes

La API permite exportar reportes en formato Excel con información sobre:
- Inventario completo de libros
- Historial de préstamos
- Reportes de usuarios activos
- Reporte general

## Diagrama de la base de datos:

<img width="1225" height="1112" alt="libros(2)" src="https://github.com/user-attachments/assets/f2ed736a-741c-42a7-8c8c-b9baf25cb735" />
