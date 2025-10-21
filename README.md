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
<img width="1307" height="1139" alt="libros" src="https://github.com/user-attachments/assets/bc66ef67-9ebf-405b-b2b9-9ae88b96aa62" />





## 📜 Listado de endpoints 
la api cuenta con multiples rutas que nos permite la creación, eliminación, actualización y lectura del aplicativo.

<a name="indice"></a>
## 📑 Índice de Endpoints

- 👤 [1. Crear Usuario](#1-crear-usuario)
- 📋 [2. Listar Todos los Usuarios](#2-listar-todos-los-usuarios)
- 🔍 [3. Buscar Usuario por ID](#3-buscar-usuario-por-id)
- 🗑️ [4. Eliminar Usuario](#4-eliminar-usuario)
- ❤️ [5. Agregar Like a Libro](#5-agregar-like-a-libro)
- 💔 [6. Eliminar Like de Libro](#6-eliminar-like-de-libro)
- 📚 [7. Agregar Libro a Librería](#7-agregar-libro-a-librería)
- 🗑️ [8. Eliminar Libro de Librería](#8-eliminar-libro-de-librería)
- 📖 [9. Obtener Libros Favoritos del Usuario](#9-obtener-libros-favoritos-del-usuario)
- 📂 [10. Crear Categoría](#10-crear-categoría)
- 🗑️ [11. Eliminar Categoría](#11-eliminar-categoría)
- 📊 [12. Contar Categorías](#12-contar-categorías)
- ✍️ [13. Crear Autor](#13-crear-autor)
- 📚 [14. Listar Todos los Autores](#14-listar-todos-los-autores)
- 🔍 [15. Buscar Autor por ID con Libros](#15-buscar-autor-por-id-con-libros)
- 🗑️ [16. Eliminar Autor](#16-eliminar-autor)
- 📖 [17. Asociar Libro a Autor](#17-asociar-libro-a-autor)
- 🗑️ [18. Eliminar Libro de Autor](#18-eliminar-libro-de-autor)
- 📊 [19. Contar Autores](#19-contar-autores)
- 📘 [20. Crear Libro](#20-crear-libro)
- 📚 [21. Listar Todos los Libros](#21-listar-todos-los-libros)
- 🔍 [22. Buscar Libro por ID con Detalles](#22-buscar-libro-por-id-con-detalles)
- ❤️ [23. Obtener Usuarios que Dieron Like a Libro](#23-obtener-usuarios-que-dieron-like-a-libro)
- 📊 [24. Contar Likes de Libro](#24-contar-likes-de-libro)
- 🏷️ [25. Agregar Categoría a Libro](#25-agregar-categoría-a-libro)
- 🗑️ [26. Eliminar Categoría de Libro](#26-eliminar-categoría-de-libro)
- 📊 [27. Contar Libros](#27-contar-libros)
- 📈 [28. Contar Libros por Categoría](#28-contar-libros-por-categoría)
- 💬 [29. Crear Comentario](#29-crear-comentario)
- 📊 [30. Exportar Reporte General Excel](#30-exportar-reporte-general-excel)
- 📚 [31. Solicitar Préstamo](#31-solicitar-préstamo)
- 📋 [32. Listar Todos los Préstamos](#32-listar-todos-los-préstamos)
- ✅ [33. Aprobar Préstamo](#33-aprobar-préstamo)
- 🔄 [34. Devolver Préstamo](#34-devolver-préstamo)
- ❌ [35. Rechazar Préstamo](#35-rechazar-préstamo)
- 👤 [36. Obtener Préstamos por Usuario](#36-obtener-préstamos-por-usuario)
- 🔐 [37. Login de Usuario](#37-login-de-usuario)
- 🌍 [38. Obtener Nacionalidades](#38-obtener-nacionalidades)
- 📊 [39. Obtener Estados de Préstamo](#39-obtener-estados-de-préstamo)
---

<a name="1-crear-usuario"></a>
## 👤 1. Crear Usuario [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/users`
**Validación:** `SIN AUTENTICACIÓN` 

#### 📝 Descripción
Crea un nuevo usuario con los datos suministrados y envía una notificación por correo electrónico.

#### 📥 Request Body
```json
{
    "username": "pburgos",
    "password": "123456",
    "email": "xxxxxxxxxxxxxxxxx@gmail.com",
    "isAdmin": true
}
```

#### ✅ Respuesta exitosa
```json
{
    "code": 201,
    "message": "Created",
    "data": {
        "id": 4,
        "username": "pburgos",
        "email": "xxxxxxxxxxxxx@gmail.com"
    }
}
```
#### ❌ Respuesta de validación
```json
{
    "code": 400,
    "message": "Algunos de los argumentos ingresados no son correctos",
    "data": [
        "password: no debe estar vacío",
        "username: no debe estar vacío",
        "email: no debe estar vacío"
    ]
}
```
#### 📧 Notificación
Nota: Se enviará un correo electrónico de notificación al usuario registrado.

<a name="2-listar-todos-los-usuarios"></a>
## 📋 2. Listar Todos los Usuarios [🔙](#indice)

**Método: GET**
**Endpoint: /api/v1/users**
**Validación:** `SIN AUTENTICACIÓN` 

#### 📝 Descripción
Este endpoint proporciona un listado completo de todos los usuarios registrados. No requiere autenticación.

#### ✅ Respuesta exitosa
```json
{
    "code": 200,
    "message": "Lista de usuarios",
    "data": [
        {
            "id": 1,
            "username": "lpinedo",
            "email": "xxxxxxxxxxxxxxxx@gmail.com"
        }
    ]
}
```

<a name="3-buscar-usuario-por-id"></a>
**Método: GET**
**Endpoint: /api/v1/users/{id}**
**Validación:** `USER_ROLE` 
#### 📝 Descripción
Busca y retorna la información de un usuario específico por su ID.

#### ✅ Respuesta exitosa
```json
{
    "code": 200,
    "message": "Usuario encontrado",
    "data": {
        "id": 1,
        "username": "lpinedo",
        "email": "pinedo.burgoslp3@gmail.com",
        "roles": [
            {
                "name": "ROLE_USER",
                "description": "rol para los usuarios del ebook"
            }
        ]
    }
}
```
#### ❌ Respuesta de validación del ID
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```
<a name="4-eliminar-usuario"></a>
## 🗑️ 4. Eliminar Usuario [🔙](#indice)

**Método:** `DELETE`  
**Endpoint:** `/api/v1/users/{id}`
**Validación:** `ADMIN_ROLE` 

#### 📝 Descripción
Elimina un usuario por su ID y en cascada elimina todos sus comentarios, likes y librerías personales.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "Usuario eliminado exitosamente",
    "data": "Usuario y todos sus datos asociados han sido eliminados"
}
```
#### ❌ Respuesta de validación del ID
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```
<a name="5-agregar-like-a-libro"></a>
## ❤️ 5. Agregar Like a Libro [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/users/{id}/likes/{bookId}`
**Validación:** `USER_ROLE` 

#### 📝 Descripción
Agrega un like de un usuario a un libro específico.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "like agregado correctamente"
}
```
#### ❌ Respuesta de validación del ID del user
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

<a name="6-eliminar-like-de-libro"></a>
## 💔 6. Eliminar Like de Libro [🔙](#indice)

**Método:** `DELETE`  
**Endpoint:** `/api/v1/users/{id}/likes/{bookId}`
**Validación:** `USER_ROLE`
 
#### 📝 Descripción
Elimina el like de un usuario a un libro específico.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "like eliminado correctamente"
}
```

#### ❌ Validación del User ID
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

<a name="7-agregar-libro-a-librería"></a>
## 📚 7. Agregar Libro a Librería [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/users/{id}/library/{bookId}`
**Validación:** `USER_ROLE`

#### 📝 Descripción
Agrega un libro a la librería de favoritos del usuario seleccionado.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Libro agregado a la librería correctamente"
}
```

#### ❌ Validación del User ID
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

<a name="8-eliminar-libro-de-librería"></a>
## 🗑️ 8. Eliminar Libro de Librería [🔙](#indice)

**Método:** `DELETE`  
**Endpoint:** `/api/v1/users/{id}/library/{bookId}`
**Validación:** `USER_ROLE`

#### 📝 Descripción
Elimina el libro seleccionado de los favoritos del usuario.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Libro eliminado de la librería correctamente"
}
```
#### ❌ Validación del User ID
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

<a name="9-obtener-libros-favoritos-del-usuario"></a>
## 📖 9. Obtener Libros Favoritos del Usuario [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/users/{id}/library`
**Validación:** `USER_ROLE`

#### 📝 Descripción
Obtiene todos los libros favoritos de la librería del usuario.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": {
        "username": "pburgos",
        "libraries": [
            {
                "id": 1,
                "title": "Don Quijote de la Mancha",
                "publicationDate": "1605-01-16",
                "publisher": "Francisco de Robles",
                "isbn": "978-1-56619-909-4",
                "synopsis": "Las aventuras de un hidalgo que, influenciado por los libros de caballerías, decide convertirse en caballero andante y salir en busca de aventuras.",
                "cover": "don_quijote.jpg",
                "available": 4
            },
            {
                "id": 2,
                "title": "El Principito",
                "publicationDate": "1943-04-06",
                "publisher": "Reynal & Hitchcock",
                "isbn": "978-1-56619-909-5",
                "synopsis": "La historia de un piloto que, tras un accidente en el desierto del Sahara, encuentra a un pequeño príncipe venido de otro planeta.",
                "cover": "el_principito.jpg",
                "available": 5
            }
        ]
    }
}
```

#### ❌ Validación del User ID
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```

<a name="10-crear-categoría"></a>
## 📂 10. Crear Categoría [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/categories`
**Validación:** `ADMIN_ROLE`
#### 📝 Descripción
Crea una nueva categoría para clasificar libros.

#### 📥 Request Body
```json
{
    "name": "terror",
    "description": "libros de terror"
}
```

#### ✅ Respuesta Exitosa
```json
{
    "code": 201,
    "message": "Se ha creado la categoria correctamente",
    "data": {
        "id": 5,
        "name": "terror",
        "description": "libros de terror"
    }
}
```

#### ❌ Validación del nombre de la categoria
```json
{
    "code": 400,
    "message": "Algunos de los argumentos ingresados no son correctos",
    "data": [
        "name: El nombre ya esta en uso"
    ]
}
```

<a name="11-eliminar-categoría"></a>
## 🗑️ 11. Eliminar Categoría [🔙](#indice)

**Método:** `DELETE`  
**Endpoint:** `/api/v1/categories/{id}`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Elimina la categoría especificada por ID.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Categoria eliminada correctamente"
}
```
#### ❌ Validación del ID de la categoría
```json
{
    "code": 404,
    "message": "No se encontró la categoría por id",
    "data": [""]
}
```

<a name="12-contar-categorías"></a>
## 📊 12. Contar Categorías [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/categories/count`
**Validación:** `SIN AUTENTICACIÓN`

#### 📝 Descripción
Obtiene el conteo total de categorías existentes en el sistema.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": 5
}
```

<a name="13-crear-autor"></a>
## ✍️ 13. Crear Autor [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/authors`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Crea un nuevo autor en el sistema.

#### 📥 Request Body
```json
{   
    "name":"alfredo",
    "lastname":"vargas",
    "birthDate": "2025-12-05",
    "biography":"una description de su vida aqui",
    "nationalityId":"6",
    "image":"book.jpg"
}
```
#### ✅ Respuesta Exitosa
```json
{
    "code": 201,
    "message": "Created",
    "data": {
        "id": 4,
        "name": "alfredo",
        "lastname": "vargas",
        "birthDate": "2025-12-05T00:00:00",
        "biography": "una description de su vida aqui",
        "createdAt": "2025-10-08T12:00:28.0855917",
        "updatedAt": null,
        "image": "book.jpg",
        "nationality": {
            "demonym": "Antiguano"
        }
    }
}
```

#### ❌ Validación del Request Body
```json
{
    "code": 400,
    "message": "Algunos de los argumentos ingresados no son correctos",
    "data": [
        "birthDate: no debe estar vacío",
        "name: no debe estar vacío",
        "lastname: no debe estar vacío",
        "nationality: no debe estar vacío",
        "biography: no debe estar vacío"
    ]
}
```

#### ❌ Validación del Formato de Fecha
```json
{
    "code": 400,
    "message": "Algunos de los argumentos ingresados no son correctos",
    "data": [
        "birthDate: la fecha de nacimiento debe tener el siguiente formato YYYY-MM-DD"
    ]
}
```

<a name="14-listar-todos-los-autores"></a>
## 📚 14. Listar Todos los Autores [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/authors`
**Validación:** `SIN AUTENTICACIÓN`

#### 📝 Descripción
Muestra todos los autores registrados en el sistema.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 1,
            "name": "Antoine",
            "lastname": "de Saint-Exupéry",
            "birthDate": "1900-06-29",
            "nationality": "Francés",
            "biography": "Fue un escritor y aviador francés, conocido principalmente por su obra El Principito.",
            "createdAt": "2025-09-09T19:39:08",
            "updatedAt": null,
            "image": "Francés"
        },
        {
            "id": 2,
            "name": "Gabriel",
            "lastname": "García Márquez",
            "birthDate": "1927-03-06",
            "nationality": "Colombiano",
            "biography": "Fue un escritor, guionista y periodista colombiano, conocido por su obra Cien Años de Soledad.",
            "createdAt": "2025-09-09T19:39:08",
            "updatedAt": null,
            "image": "Colombiano"
        }
    ]
}
```

<a name="15-buscar-autor-por-id-con-libros"></a>
## 🔍 15. Buscar Autor por ID con Libros [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/authors/{id}`
**Validación:** `SIN AUTENTICACIÓN`

#### 📝 Descripción
Muestra un autor específico según su ID y todos los libros relacionados al autor.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": {
        "id": 1,
        "name": "Antoine",
        "lastname": "de Saint-Exupéry",
        "birthDate": "1900-06-29",
        "nationality": "Francés",
        "biography": "Fue un escritor y aviador francés, conocido principalmente por su obra El Principito.",
        "createdAt": "2025-09-09T19:39:08",
        "updatedAt": null,
        "image": "Francés",
        "books": [
            {
                "id": 1,
                "title": "Don Quijote de la Mancha",
                "publicationDate": "1605-01-16",
                "publisher": "Francisco de Robles",
                "isbn": "978-1-56619-909-4",
                "synopsis": "Las aventuras de un hidalgo que, influenciado por los libros de caballerías, decide convertirse en caballero andante y salir en busca de aventuras.",
                "cover": "don_quijote.jpg",
                "available": 4
            }
        ]
    }
}
```

#### ❌ Validación del id del author
```json
{
    "code": 404,
    "message": "No se encontró el autor por id",
    "data": [
        ""
    ]
}
```
<a name="16-eliminar-autor"></a>
## 🗑️ 16. Eliminar Autor [🔙](#indice)

**Método:** `DELETE`  
**Endpoint:** `/api/v1/authors/{id}`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Elimina un autor específico por su ID.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Autor eliminado correctamente"
}
```

#### ❌ Validación del id del author
```json
{
    "code": 404,
    "message": "No se encontró el autor por id",
    "data": [""]
}
```

<a name="17-asociar-libro-a-autor"></a>
## 📖 17. Asociar Libro a Autor [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/authors/{id}/books/{bookId}`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Asocia un libro existente a un autor mediante el ID del autor y el ID del libro.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Libro agregado al autor correctamente"
}
```

#### ❌ Validación del id del author
```json
{
    "code": 404,
    "message": "No se encontró el autor por id",
    "data": [""]
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```
<a name="18-eliminar-libro-de-autor"></a>
## 🗑️ 18. Eliminar Libro de Autor [🔙](#indice)

**Método:** `DELETE`  
**Endpoint:** `/api/v1/authors/{id}/books/{bookId}`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Elimina la asociación de un libro específico con el autor seleccionado.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Libro eliminado del autor correctamente"
}
```

#### ❌ Validación del id del author
```json
{
    "code": 404,
    "message": "No se encontró el autor por id",
    "data": [""]
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```
<a name="19-contar-autores"></a>
## 📊 19. Contar Autores [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/authors/count`
**Validación:** `SIN AUTENTICACIÓN`

#### 📝 Descripción
Obtiene el conteo total de autores registrados en el sistema.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": 3
}
```

<a name="20-crear-libro"></a>
## 📘 20. Crear Libro [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/books`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Crea un nuevo libro en el sistema.

#### 📥 Request Body
```json
{
    "title": "titulo",
    "publicationDate": "2025-05-05",
    "publisher": "marianoRecords",
    "isbn": "8874",
    "synopsis": "resumen del libro",
    "cover": "portada.jpg",
    "available": 5
}
```

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": {
        "id": 4,
        "title": "titulo",
        "publicationDate": "2025-05-05",
        "publisher": "marianoRecords",
        "isbn": "8874",
        "synopsis": "resumen del libro",
        "cover": "portada.jpg",
        "available": 5
    }
}
```

#### ❌ Validación del Request Body
```json
{
    "code": 400,
    "message": "Algunos de los argumentos ingresados no son correctos",
    "data": [
        "available: no debe ser nulo",
        "publisher: no debe estar vacío",
        "publicationDate: no debe ser nulo",
        "isbn: no debe estar vacío",
        "cover: no debe estar vacío",
        "title: no debe estar vacío",
        "synopsis: no debe estar vacío"
    ]
}
```

#### ❌ Validación del Formato de Fecha
```json
{
    "code": 400,
    "message": "Algunos de los argumentos ingresados no son correctos",
    "data": [
        "publicationDate: la fecha de publicación debe tener el siguiente formato YYYY-MM-DD"
    ]
}
```
<a name="21-listar-todos-los-libros"></a>
## 📚 21. Listar Todos los Libros [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/books`
**Validación:** `SIN AUTENTICACIÓN`

#### 📝 Descripción
Muestra todos los libros registrados en la librería con su cantidad disponible.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 1,
            "title": "Don Quijote de la Mancha",
            "publicationDate": "1605-01-16",
            "publisher": "Francisco de Robles",
            "isbn": "978-1-56619-909-4",
            "synopsis": "Las aventuras de un hidalgo que, influenciado por los libros de caballerías, decide convertirse en caballero andante y salir en busca de aventuras.",
            "cover": "don_quijote.jpg",
            "available": 4
        },
        {
            "id": 2,
            "title": "El Principito",
            "publicationDate": "1943-04-06",
            "publisher": "Reynal & Hitchcock",
            "isbn": "978-1-56619-909-5",
            "synopsis": "La historia de un piloto que, tras un accidente en el desierto del Sahara, encuentra a un pequeño príncipe venido de otro planeta.",
            "cover": "el_principito.jpg",
            "available": 5
        }
    ]
}
```
<a name="22-buscar-libro-por-id-con-detalles"></a>
## 🔍 22. Buscar Libro por ID con Detalles [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/books/{id}`
**Validación:** `SIN AUTENTICACIÓN `

#### 📝 Descripción
Muestra el detalle completo del libro seleccionado, incluyendo autores, comentarios y categorías.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": {
        "id": 2,
        "title": "El Principito",
        "publicationDate": "1943-04-06",
        "publisher": "Reynal & Hitchcock",
        "isbn": "978-1-56619-909-5",
        "synopsis": "La historia de un piloto que, tras un accidente en el desierto del Sahara, encuentra a un pequeño príncipe venido de otro planeta.",
        "cover": "el_principito.jpg",
        "available": 5,
        "comments": [
            {
                "id": 1,
                "description": "este libro es muy bueno",
                "user": {
                    "id": 3,
                    "username": "pburgos",
                    "email": "pinedo.burgoslp3@gmail.com"
                }
            }
        ],
        "authors": [
            {
                "id": 1,
                "name": "Antoine",
                "lastname": "de Saint-Exupéry",
                "birthDate": "1900-06-29",
                "nationality": "Francés",
                "biography": "Fue un escritor y aviador francés, conocido principalmente por su obra El Principito.",
                "createdAt": "2025-09-09T19:39:08",
                "updatedAt": null,
                "image": "Francés"
            }
        ],
        "categories": [
            {
                "id": 2,
                "name": "Clásicos",
                "description": "Obras literarias que han perdurado a lo largo del tiempo y son consideradas de gran valor cultural."
            }
        ]
    }
}
```
#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

<a name="23-obtener-usuarios-que-dieron-like-a-libro"></a>
## ❤️ 23. Obtener Usuarios que Dieron Like a Libro [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/books/{id}/usersWhoLiked`
**Validación:** `SIN AUTENTICACIÓN `

#### 📝 Descripción
Muestra todos los usuarios que han dado like al libro seleccionado.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 3,
            "username": "pburgos",
            "email": "pinedo.burgoslp3@gmail.com"
        }
    ]
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

<a name="24-contar-likes-de-libro"></a>
## 📊 24. Contar Likes de Libro [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/books/{id}/countLikes`
**Validación:** `SIN AUTENTICACIÓN `

#### 📝 Descripción
Obtiene el conteo total de likes que ha recibido el libro seleccionado.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": 1
}
```
#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

<a name="25-agregar-categoría-a-libro"></a>
## 🏷️ 25. Agregar Categoría a Libro [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/books/{bookId}/categories/{categoryId}`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Agrega una categoría específica a un libro.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Categoría añadida correctamente"
}
```

#### ❌ Validación de Categoría Repetida
```json
{
    "code": 404,
    "message": "La categoría ya está asociada al libro",
    "data": [""]
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

#### ❌ Validación del Category ID
```json
{
    "code": 404,
    "message": "No se encontró la categoría por id",
    "data": [""]
}
```
<a name="26-eliminar-categoría-de-libro"></a>
## 🗑️ 26. Eliminar Categoría de Libro [🔙](#indice)

**Método:** `DELETE`  
**Endpoint:** `/api/v1/books/{id}/categories/{idCategory}`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Elimina una categoría específica de un libro.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Categoría eliminada correctamente"
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

#### ❌ Validación del Category ID
```json
{
    "code": 404,
    "message": "No se encontró la categoría por id",
    "data": [""]
}
```
<a name="27-contar-libros"></a>
## 📊 27. Contar Libros [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/books/count`
**Validación:** `SIN AUTENTICACIÓN`

#### 📝 Descripción
Muestra la cantidad total de libros ingresados en el sistema.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": 4
}
```

<a name="28-contar-libros-por-categoría"></a>
## 📈 28. Contar Libros por Categoría [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/books/countByCategory`
**Validación:** `SIN AUTENTICACIÓN`

#### 📝 Descripción
Muestra todas las categorías y la cantidad de libros asociados a cada una.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": [
        {
            "categoryName": "Clásicos",
            "totalBooks": 6
        },
        {
            "categoryName": "Aventura",
            "totalBooks": 5
        },
        {
            "categoryName": "Fantasía",
            "totalBooks": 16
        },
        {
            "categoryName": "terror",
            "totalBooks": 3
        },
        {
            "categoryName": "drama",
            "totalBooks": 4
        }
    ]
}
```

<a name="29-crear-comentario"></a>
## 💬 29. Crear Comentario [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/comments`
**Validación:** `USER_ROLE`

#### 📝 Descripción
Crea un comentario en un libro específico.

#### 📥 Request Body
```json
{
    "description": "este libro es muy bueno",
    "userId": 3,
    "bookId": 2
}
```

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Comentario guardado con exito"
}
```

#### ❌ Validación del User ID
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```

#### ❌ Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

<a name="30-exportar-reporte-general-excel"></a>
## 📊 30. Exportar Reporte General Excel [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/excels/report/general`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Exporta un archivo en formato XML que puede ser abierto como Excel para visualizar un análisis general de la librería.

#### ✅ imagen del reporte
<img width="911" height="306" alt="imagen" src="https://github.com/user-attachments/assets/b0a50c7c-ec73-4657-ba71-581f8ed30289" />

<a name="31-solicitar-préstamo"></a>
## 📚 31. Solicitar Préstamo [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/loans/request`
**Validación:** `USER_ROLE`

#### 📝 Descripción
Crea una solicitud de préstamo para un libro y envía un correo electrónico de notificación al usuario.

#### 📥 Request Body
```json
{
    "userId": "1",
    "bookId": "1"
}
```

#### ✅ Respuesta Exitosa
```json
{
    "code": 201,
    "message": "Created",
    "data": "Prestamo Solicitado con exito"
}
```

#### ❌Validación del Book ID
```json
{
    "code": 404,
    "message": "No se encontró el libro por id",
    "data": [""]
}
```

#### ❌ Validación del User ID
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```

#### ❌ Validación de Stock del Libro
```json
{
    "code": 404,
    "message": "El libro no tiene existencias disponibles en este momento",
    "data": [""]
}
```

<a name="32-listar-todos-los-préstamos"></a>
## 📋 32. Listar Todos los Préstamos [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/loans`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Muestra todos los préstamos solicitados por los usuarios para los libros.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 1,
            "user": {
                "id": 3,
                "username": "pburgos",
                "email": "pinedo.burgoslp3@gmail.com"
            },
            "book": {
                "id": 1,
                "title": "Don Quijote de la Mancha",
                "publicationDate": "1605-01-16",
                "publisher": "Francisco de Robles",
                "isbn": "978-1-56619-909-4",
                "synopsis": "Las aventuras de un hidalgo que, influenciado por los libros de caballerías, decide convertirse en caballero andante y salir en busca de aventuras.",
                "cover": "don_quijote.jpg",
                "available": 4
            },
            "status": "pending",
            "requestDate": "2025-10-07T09:50:50",
            "loanDate": null,
            "returnDate": null
        }
    ]
}
```
<a name="33-aprobar-préstamo"></a>
## ✅ 33. Aprobar Préstamo [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/loans/aprove/{idLoan}`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Aprueba el préstamo seleccionado que está en estado pendiente. Una vez aprobado, se notificará al usuario mediante correo electrónico con la información de la fecha de devolución del mismo.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Prestamo Aprobado con exito"
}
```

#### ❌ del id del prestamo
```json
{
    "code": 404,
    "message": "No se encontró el prestamo solicitado",
    "data": [
        ""
    ]
}
```
<a name="34-devolver-préstamo"></a>
## 🔄 34. Devolver Préstamo [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/loans/returned/{idloan}`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Realiza la devolución del libro que el usuario ha realizado, recalculando las cantidades disponibles a su estado inicial anterior al préstamo.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Prestamo Devuelto con exito"
}
```

#### ❌ Validación del Loan ID
```json
{
    "code": 404,
    "message": "No se encontró el prestamo solicitado",
    "data": [""]
}
```


#### ❌ Validación del Estado del Préstamo
```json
{
    "code": 404,
    "message": "El prestamo solicitado no ha sido aprovado o fué descartado",
    "data": [""]
}
```

<a name="35-rechazar-préstamo"></a>
## ❌ 35. Rechazar Préstamo [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/loans/rejected/{id}`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Rechaza los préstamos de libros solicitados por los usuarios y notifica al usuario mediante correo electrónico.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": "Prestamo Rechazado con exito"
}
```

#### ❌ Validación del Loan ID
```json
{
    "code": 404,
    "message": "No se encontró el prestamo solicitado",
    "data": [""]
}
```

<a name="36-obtener-préstamos-por-usuario"></a>
## 👤 36. Obtener Préstamos por Usuario [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/loans/user/{id}`
**Validación:** `USER_ROLE`
#### 📝 Descripción
Obtiene todos los préstamos que ha realizado un usuario específico.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 2,
            "user": {
                "id": 4,
                "username": "pburg",
                "email": "pinedo.burgoslp3@gmail.com"
            },
            "book": {
                "id": 3,
                "title": "Cien Años de Soledad",
                "publicationDate": "1967-05-30",
                "publisher": "Editorial Sudamericana",
                "isbn": "978-1-56619-909-6",
                "synopsis": "Una novela que narra la historia de la familia Buendía a lo largo de varias generaciones en el pueblo ficticio de Macondo.",
                "cover": "cien_anos_de_soledad.jpg",
                "available": 3
            },
            "status": "pending",
            "requestDate": "2025-10-07T10:10:08",
            "loanDate": null,
            "returnDate": null
        }
    ]
}
```
#### ❌ Validación del User ID
```json
{
    "code": 404,
    "message": "No se encontró el usuario por id",
    "data": [""]
}
```
<a name="37-login-de-usuario"></a>
## 🔐 37. Login de Usuario [🔙](#indice)

**Método:** `POST`  
**Endpoint:** `/api/v1/login`
**Validación:** `SIN AUTENTICACIÓN`

#### 📝 Descripción
Autentica a un usuario en el sistema y genera un token de acceso, la duracción del token es de 2 horas luego de ser generado.

#### ✅ Respuesta Exitosa
```json
{
    "message": "Usuario autenticado correctamente",
    "username": "pburgos",
    "roles": [
        "ROLE_ADMIN",
        "ROLE_USER"
    ],
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYnVyZ29zIiwiZXhwIjoxNzU5ODU1OTMwLCJpYXQiOjE3NTk4NDg3MzAsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwidXNlcm5hbWUiOiJwYnVyZ29zIn0.mNtOnDqoRiKI-Mf_gtmefgrHJnjXPzytLKNZnlX7Ijg"
}
```

<a name="38-obtener-nacionalidades"></a>
## 🌍 38. Obtener Nacionalidades [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/nationalities`
**Validación:** `ADMIN_ROLE`

#### 📝 Descripción
Obtiene todas las nacionalidades disponibles para registrar los autores.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 1,
            "name": "Afganistán",
            "demonym": "Afgano",
            "isoCode": "AFG"
        },
        {
            "id": 2,
            "name": "Albania",
            "demonym": "Albanés",
            "isoCode": "ALB"
        },
        {
            "id": 3,
            "name": "Alemania",
            "demonym": "Alemán",
            "isoCode": "DEU"
        }
    ]
}
```

<a name="39-obtener-estados-de-préstamo"></a>
## 📊 39. Obtener Estados de Préstamo [🔙](#indice)

**Método:** `GET`  
**Endpoint:** `/api/v1/status`

#### 📝 Descripción
Obtiene todos los estados disponibles para los préstamos del sistema.

#### ✅ Respuesta Exitosa
```json
{
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 1,
            "name": "aproved",
            "description": "El prestamo ha sido aprobado."
        },
        {
            "id": 2,
            "name": "pending",
            "description": "El prestamo esta pendiente para su revisión."
        },
        {
            "id": 3,
            "name": "rejected",
            "description": "El prestamo ha sido rechazado por revisión."
        },
        {
            "id": 4,
            "name": "returned",
            "description": "El prestamo ha finalizado y se ha devuelto el libro con exito."
        }
    ]
}
```
