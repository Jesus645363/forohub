# 💬 ForoHub API

🚀 API REST desarrollada con **Spring Boot** que simula el funcionamiento de un foro donde los usuarios pueden crear, consultar, actualizar y eliminar tópicos.

Este proyecto fue desarrollado como parte del **Challenge Back-End de Alura Latam**, aplicando buenas prácticas de desarrollo con Java y arquitectura de APIs.

---

## 📌 Descripción del proyecto

**ForoHub** es una API que permite gestionar un sistema de foros similar al que utilizan muchas plataformas de aprendizaje o comunidades en línea.

Los usuarios pueden:

- 📝 Crear nuevos tópicos  
- 🔎 Consultar tópicos existentes  
- ✏️ Actualizar información de un tópico  
- ❌ Eliminar tópicos  

La aplicación implementa **autenticación segura mediante JWT**, lo que protege los endpoints y asegura que solo usuarios autenticados puedan interactuar con el sistema.

---

## 🧰 Tecnologías utilizadas

| Tecnología | Uso |
|------------|-----|
| ☕ **Java 17** | Lenguaje principal |
| 🌱 **Spring Boot** | Framework para desarrollo de la API |
| 🔐 **Spring Security** | Manejo de autenticación y seguridad |
| 🪪 **JWT (JSON Web Token)** | Autenticación basada en tokens |
| 🗄 **H2 Database** | Base de datos en memoria |
| 🧬 **JPA / Hibernate** | Persistencia de datos |
| 📦 **Maven** | Gestión de dependencias |

---

## 📂 Estructura del proyecto

El proyecto sigue una estructura organizada para mantener separación de responsabilidades.

```
src
 └─ main
     └─ java
         └─ com.alura.forohub
             ├─ controller
             │   └─ Manejo de endpoints de la API
             │
             ├─ domain
             │   └─ Entidades del sistema
             │
             ├─ dto
             │   └─ Objetos de transferencia de datos
             │
             ├─ repository
             │   └─ Acceso a la base de datos
             │
             ├─ service
             │   └─ Lógica de negocio
             │
             └─ security
                 └─ Configuración de autenticación JWT
bash```
````
---

## 🔑 Autenticación

La API utiliza **JWT (JSON Web Token)** para la autenticación.

Flujo básico:

1️⃣ El usuario envía sus credenciales al endpoint `/login`  
2️⃣ El servidor genera un **token JWT**  
3️⃣ El cliente usa ese token en el header:
4️⃣ Los endpoints protegidos validan el token antes de responder.

---

## 📡 Endpoints principales

### 🔐 Autenticación

Genera el token JWT para acceder a la API.

---

### 📝 Crear tópico

Permite registrar un nuevo tópico en el foro.

---

### 📄 Listar tópicos

Devuelve todos los tópicos registrados.

---

### ✏️ Actualizar tópico

Actualiza la información de un tópico existente.

---

### ❌ Eliminar tópico

Elimina un tópico del sistema.

---

## ▶️ Cómo ejecutar el proyecto

1️⃣ Clonar el repositorio

```
git clone https://github.com/jesus645363/forohub.git
```

2️⃣ Entrar al proyecto 

cd forohub

3️⃣ Ejecutar con Maven

``bash ./mvnw spring-boot:run
``

 La API estará disponible en:

 
``
http://localhost:8080
``

---


##🧪 Pruebas de la API

Puedes probar los endpoints utilizando herramientas como:

- 🧪 Postman
- 📮 Insomnia
- 🧰 Thunder Client (VS Code)

Primero obtén el token JWT desde /login y luego úsalo para acceder a los endpoints protegidos.

---

##🎯 Objetivo del proyecto

Este proyecto fue desarrollado para practicar:

- Desarrollo de APIs REST
- Implementación de Spring Security
- Autenticación con JWT
- Uso de JPA / Hibernate
- Organización de proyectos backend profesionales

---

##👨‍💻 Autor

Jesús Castillo Daniiel

Estudiante de desarrollo backend enfocado en Java y Spring Boot.

---

⭐ Si te gustó el proyecto
Puedes darle una estrella al repositorio en GitHub ⭐
Eso ayuda a que más personas puedan encontrarlo.
