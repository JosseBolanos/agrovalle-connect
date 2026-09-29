# 👥 Bitácora de Daily Scrums — Sprint 1 (Grupo 8)

Este documento registra las reuniones diarias de sincronización (máximo 15 minutos) de la célula Scrum para el proyecto AgroValle Connect, monitoreando avances y bloqueos técnicos.

---

### 🗓️ Día 1: Sincronización Inicial del Sprint
* **Participantes:** Emmanuel Vidal, Josse Manuel Bolaños, Michael David Robayos.
* **Emmanuel Vidal (Backend):**
  * **¿Qué hizo ayer?:** Estudió los contratos de la API REST sugeridos en la planeación y revisó la estructura base del proyecto Java 17 en VS Code.
  * **¿Qué hará hoy?:** Diseñar e implementar la estructura de la carpeta `models` y escribir la entidad `Agricultor.java` con las validaciones JPA (`@NotBlank`, `@Size`).
  * **¿Qué bloqueos tiene?:** Ninguno por el momento, resolviendo dudas de las dependencias de validación de Spring Boot.
* **Josse Manuel Bolaños (DevOps / QA):**
  * **¿Qué hizo ayer?:** Inicializó el tablero Kanban en GitHub Projects y configuró las políticas de WIP Limits (En progreso <= 3).
  * **¿Qué hará hoy?:** Configurar el linter en el archivo `checkstyle.xml` en la raíz del proyecto para asegurar las reglas de estilo de código.
  * **¿Qué bloqueos tiene?:** Sincronizar las alertas visuales del tablero web.
* **Michael David Robayos (Fullstack):**
  * **¿Qué hizo ayer?:** Apoyó la redacción y limpieza de las 18 historias del Product Backlog consolidado.
  * **¿Qué hará hoy?:** Estructurar la interfaz de persistencia `AgricultorRepository.java` extendiendo de `JpaRepository`.
  * **¿Qué bloqueos tiene?:** Ninguno.

---

### 🗓️ Día 2: Control de Calidad e Integración local
* **Participantes:** Emmanuel Vidal, Josse Manuel Bolaños, Michael David Robayos.
* **Emmanuel Vidal (Backend):**
  * **¿Qué hizo ayer?:** Creó exitosamente la entidad `Agricultor.java` con restricciones de integridad de datos de la norma ISO 25010.
  * **¿Qué hará hoy?:** Resolver los conflictos de líneas duplicadas en el archivo `README.md` junto con el equipo y preparar el primer commit semántico (`feat(model):`).
  * **¿Qué bloqueos tiene?:** Experimentó un bloqueo menor con los índices de Git en la terminal local, solucionado con el apoyo de herramientas de diagnóstico.
* **Josse Manuel Bolaños (DevOps / QA):**
  * **¿Qué hizo ayer?:** Verificó el linter y preparó la estructura de carpetas de documentación.
  * **¿Qué hará hoy?:** Auditar que las tarjetas del tablero Kanban se muevan a la columna de "En curso" a medida que Emmanuel avanza en el código.
  * **¿Qué bloqueos tiene?:** Ninguno.
* **Michael David Robayos (Fullstack):**
  * **¿Qué hizo ayer?:** Desarrolló la interfaz del repositorio de datos para conectar con PostgreSQL.
  * **¿Qué hará hoy?:** Diseñar la firma del método personalizado `findByCedula` en la capa de datos para la posterior validación de identidades.
  * **¿Qué bloqueos tiene?:** Esperando la confirmación de la sincronización de la rama remota.
