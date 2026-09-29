# 🚀 Planificación del Sprint 1 — Grupo 8

* **Capacidad Estimada del Sprint:** 9 Story Points (Equilibrados por el equipo)
* **Duración del Sprint:** 2 Semanas
* **Objetivo del Sprint (Sprint Goal):** Habilitar el registro inicial de agricultores del Valle del Cauca, la consulta de perfiles de productores y el catálogo filtrado por municipio, validando la persistencia en PostgreSQL y la arquitectura REST con Spring Boot.

---

## 🛠️ Descomposición Técnica y Criterios de Calidad (ISO/IEC 25010)

Cada Historia de Usuario seleccionada para este ciclo se descompone en tareas técnicas granulares, asociando sus componentes tecnológicos y atributos de calidad de software de la norma ISO/IEC 25010.

### 🚜 HU-01: Registro de Agricultores (3 Story Points | Must Have)
* **Contrato API:** `POST /api/v1/auth/register` -> Retorna `201 Created`

| ID Tarea | Descripción Técnica de la Tarea de Ingeniería | Componente / Tecnología | Atributo ISO 25010 |
| :--- | :--- | :--- | :--- |
| **T01.1** | Implementar `@RestController` para exponer el endpoint REST de registro, mapeando el DTO de entrada. | Spring Boot (`Controller`) | Adecuación Funcional |
| **T01.2** | Crear entidad `Agricultor` mapeando campos con anotaciones de validación `@NotBlank` y restricciones de columna. | JPA / Hibernate (`Model`) | Integridad de Datos |
| **T01.3** | Configurar la interfaz funcional `AgricultorRepository` heredando y extendiendo de `JpaRepository`. | Spring Data JPA (`Repository`) | Mantenibilidad |
| **T01.4** | Desarrollar la lógica de negocio en la capa Service para coordinar la validación y verificación de cédula única. | Java 17 (`Service`) | Correctitud Funcional |
| **T01.5** | **[OBLIGATORIA]** Traducir el escenario BDD Given-When-Then de la HU-01 a métodos de prueba unitarios automatizados. | JUnit 5 / MockMvc / Mockito | Fiabilidad |

---

### 👤 HU-07: Consulta de Perfil Público del Agricultor (2 Story Points | Should Have)
* **Contrato API:** `GET /api/v1/productores/{id}` -> Retorna `200 OK` con DTO de consulta

| ID Tarea | Descripción Técnica de la Tarea de Ingeniería | Componente / Tecnología | Atributo ISO 25010 |
| :--- | :--- | :--- | :--- |
| **T02.1** | Desarrollar el método de búsqueda por ID en la capa de datos y verificar el mapeo correcto del objeto productor. | Spring Data JPA (`Repository`) | Adecuación Funcional |
| **T02.2** | Implementar la lógica en la capa de servicio para recuperar el registro o lanzar una excepción controlada si no existe. | Java 17 (`Service`) | Tolerancia a Fallos |
| **T02.3** | Diseñar el endpoint `GET /api/v1/productores/{id}` en el controlador retornando la entidad limpia mapeada al DTO. | Spring Boot (`Controller`) | Mantenibilidad |
| **T02.4** | Programar las pruebas unitarias aislando el servicio con mocks para asegurar el retorno exitoso del perfil y manejo del error 404. | JUnit 5 / Mockito | Fiabilidad |

---

### 🔍 HU-04: Filtro de Productos por Municipio y Categoría (3 Story Points | Must Have)
* **Contrato API:** `GET /api/v1/productos?municipio=Dagua` -> Retorna `200 OK`

| ID Tarea | Descripción Técnica de la Tarea de Ingeniería | Componente / Tecnología | Atributo ISO 25010 |
| :--- | :--- | :--- | :--- |
| **T03.1** | Desarrollar Query Method estructurado en el repositorio para ejecutar filtros combinados sobre municipio en PostgreSQL. | Spring Data JPA (`Repository`) | Eficiencia de Desempeño |
| **T03.2** | Implementar método en la capa Service para coordinar la consulta y procesar colecciones vacías de forma segura. | Java 17 (`Service`) | Correctitud Funcional |
| **T03.3** | Exponer endpoint `GET /api/v1/productos` recibiendo `@RequestParam` opcionales para municipio agrícolas. | Spring Boot (`Controller`) | Compatibilidad |
| **T03.4** | Desarrollar pruebas automatizadas de integración cargando datos semilla para validar la precisión del filtro regional. | JUnit 5 / MockMvc / H2 | Fiabilidad (Madurez) |

---

## 🧪 Traducción de Criterio BDD a Código de Prueba (Tarea Obligatoria T01.5)

### Escenario de Negocio (BDD Funcional de Cátedra)
* **Given** que el productor ingresa al formulario de registro de la plataforma.
* **When** envía sus datos con su nombre, su municipio de residencia en el Valle y una cédula válida.
* **Then** el sistema aprueba el formulario de identidad y crea su perfil transaccional de forma exitosa.

### Traducción Técnica Automatizada en Código (JUnit 5 + MockMvc)
```java
@Test
@DisplayName("Debería registrar un agricultor exitosamente cuando el payload es válido")
void registrarAgricultorExitoso() throws Exception {
    // Given (Contexto inicial del escenario)
    String agricultorJson = "{\"nombre\":\"Emmanuel Vidal\",\"ubicacion_valle\":\"Dagua\",\"cedula\":\"11223344\"}";
    Agricultor mockAgricultor = new Agricultor(1L, "Emmanuel Vidal", "Dagua", "11223344");
    
    Mockito.when(agricultorService.registrar(Mockito.any(AgricultorRequestDTO.class)))
           .thenReturn(mockAgricultor);

    // When & Then (Ejecución de la acción y verificación de resultados esperados)
    mockMvc.perform(post("/api/v1/auth/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content(agricultorJson))
            .andExpect(status().isCreated()) // Valida técnicamente el status 201 Created
            .andExpect(jsonPath("\$.id").value(1))
            .andExpect(jsonPath("\$.nombre").value("Emmanuel Vidal"))
            .andExpect(jsonPath("\$.ubicacionValle").value("Dagua"));
}
```
