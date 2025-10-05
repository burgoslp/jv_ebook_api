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
<img width="1257" height="1157" alt="libros" src="https://github.com/user-attachments/assets/5170797d-8d30-49df-8435-c661ffca71eb" />

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
    "name": "alfredo",
    "lastname": "vargas",
    "birthDate": "2025-12-05",
    "biography": "una description de su vida aqui",
    "nationality": "venezolano",
    "image": "book.jpg"
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
        "birthDate": "2025-12-05",
        "nationality": "venezolano",
        "biography": "una description de su vida aqui",
        "createdAt": "2025-10-01T11:24:24.6659092",
        "updatedAt": null,
        "image": "book.jpg"
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

