# Sanitas App

Una aplicación web de gestión de profesionales de la salud, estilo Doctoralia, desarrollada como proyecto escolar. Permite buscar especialistas, ver sus perfiles y calificaciones, y próximamente agendar citas.

---

## 📚 Tecnologías

- **Backend**  
  - Java 17, Spring Boot 3  
  - Arquitectura hexagonal (Use Cases, Ports & Adapters)  
  - MongoDB Atlas (Spring Data MongoDB)  
  - JWT (por implementar al final)
 
- **Frontend**  
  - Vue 3 + Vite  
  - Vuetify 3 (componentes y directivas importados)  
  - Pinia (estado global)  
  - Vue Router  
  - Axios (plugin global)  
  - Material Design Icons
  
- **Contenerización**  
  - Docker & Docker Compose (backend + frontend)  

---

## 🚀 Arrancar local

### Prerrequisitos

- Docker & Docker Compose  
- Node.js ≥18 + npm (para desarrollo local del frontend)  
- Java 17 + Maven (opcional, el backend via Docker)  

### Con Docker Compose

```bash
# Desde la raíz del proyecto
docker compose up --build
```

## 📦 Documentación de la API (OpenAPI / Swagger UI)

Para generar y exponer documentación OpenApi automáticamente, version 3.1.1
```url
http://localhost:8080/swagger-ui/index.html
```
