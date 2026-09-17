#  AgroValle Connect — Product Backlog

Este documento contiene el Product Backlog oficial para el proyecto **AgroValle Connect**, estructurado bajo metodología Scrum con estimación en puntos de historia (Escala de Fibonacci), priorización MoSCoW y escenarios BDD (*Given-When-Then*).

---

##  Bloque 1: Historias Base (Requerimientos de Cátedra)

###  HU-01: Registro de Agricultores
* **Prioridad:** Must Have | **Estimación:** 3 Story Points
* **Descripción:** Como Agricultor, quiero registrarme en la plataforma para ofrecer mis productos.
* **Criterios de Aceptación (BDD):**
  * **Given** que el usuario ingresa a `/api/v1/auth/register`.
  * **When** envía un JSON con `nombre`, `ubicacion_valle` y `cedula` válida.
  * **Then** el sistema responde con un status `201 Created` y el registro persiste en la base de datos PostgreSQL.

---

###  HU-02: Publicación de Productos
* **Prioridad:** Must Have | **Estimación:** 3 Story Points
* **Descripción:** Como Agricultor, quiero publicar mis cosechas para que sean visibles.
* **Criterios de Aceptación (BDD):**
  * **Given** un agricultor autenticado con token JWT.
  * **When** publica un producto con `tipo`, `cantidad` y `fecha_cosecha`.
  * **Then** el sistema valida que la fecha no sea anterior a hoy y retorna un ID de producto único.

---

###  HU-03: Visualización de Precios Regionales
* **Prioridad:** Must Have | **Estimación:** 3 Story Points
* **Descripción:** Como Usuario, quiero ver los precios promedio del Valle para negociar mejor.
* **Criterios de Aceptación (BDD):**
  * **Given** que existen 50 transacciones de "Café" en las últimas 24 horas.
  * **When** solicito el precio promedio de "Café".
  * **Then** el sistema calcula la media aritmética y despliega el valor exacto en pesos colombianos.

---

##  Bloque 2: Búsqueda y Filtrado

###  HU-04: Búsqueda y Filtrado por Municipio y Categoría
* **Prioridad:** Must Have | **Estimación:** 5 Story Points
* **Descripción:** Como Comprador, quiero filtrar las ofertas por **Municipio** y **Categoría** para encontrar cosechas en zonas específicas.
* **Criterios de Aceptación (BDD):**
  * **Given** una petición `GET` a `/api/v1/productos/buscar` con parámetros `municipio` y `categoria`.
  * **When** el servidor procesa la consulta en PostgreSQL.
  * **Then** retorna `200 OK` con la lista filtrada de productos pertenecientes a ese municipio y categoría.

---

###  HU-05: Búsqueda Rápida por Palabra Clave
* **Prioridad:** Could Have | **Estimación:** 2 Story Points
* **Descripción:** Como Usuario, quiero buscar productos escribiendo el nombre en la barra de búsqueda para acceder rápidamente.
* **Criterios de Aceptación (BDD):**
  * **Given** que el usuario ingresa un texto de búsqueda (*Ej: "Yuca", "Plátano"*).
  * **When** realiza la petición de consulta.
  * **Then** el sistema retorna los productos cuyo nombre coincida parcialmente con el texto ingresado.

---

##  Bloque 3: Transporte, Logística y Pedidos

###  HU-06: Solicitud de Pedido y Transporte por Lote
* **Prioridad:** Must Have | **Estimación:** 5 Story Points
* **Descripción:** Como Comprador, quiero solicitar un lote de producto e indicar la modalidad de transporte (*En Finca o Flete Acordado*) para iniciar la negociación.
* **Criterios de Aceptación (BDD):**
  * **Given** un comprador autenticado que selecciona un producto.
  * **When** envía la cantidad en kilos y el tipo de transporte al endpoint `/api/v1/pedidos`.
  * **Then** el sistema crea la orden en estado "Pendiente" y notifica al agricultor.

---

###  HU-07: Asignación de Punto de Recolección y Despacho
* **Prioridad:** Should Have | **Estimación:** 3 Story Points
* **Descripción:** Como Agricultor, quiero definir la dirección del centro de acopio o finca para que el transportista/comprador sepa dónde recoger la carga.
* **Criterios de Aceptación (BDD):**
  * **Given** una orden en estado "Aceptada".
  * **When** el agricultor asigna la vereda/municipio de recolección y la fecha estimada de despacho.
  * **Then** el sistema actualiza la guía de transporte vinculada al pedido.

---

###  HU-08: Confirmación de Entrega y Recepción de Carga
* **Prioridad:** Should Have | **Estimación:** 3 Story Points
* **Descripción:** Como Comprador, quiero confirmar la llegada del transporte con la cosecha para dar por finalizado el pedido.
* **Criterios de Aceptación (BDD):**
  * **Given** un pedido marcado como "En Tránsito".
  * **When** el comprador presiona "Confirmar Recepción de Carga".
  * **Then** el estado de la orden cambia a "Completado" y libera la opción de calificación.

---

##  Bloque 4: Calificación y Reputación

###  HU-09: Calificación y Reseña de Transacciones
* **Prioridad:** Should Have | **Estimación:** 3 Story Points
* **Descripción:** Como Comprador o Agricultor, quiero calificar la calidad del producto y el servicio de entrega para generar reputación en la plataforma.
* **Criterios de Aceptación (BDD):**
  * **Given** un pedido en estado "Completado".
  * **When** el usuario envía una puntuación (1 a 5 estrellas) y un comentario a `/api/v1/calificaciones`.
  * **Then** el sistema almacena la reseña y actualiza el promedio del perfil evaluado.

---

##  Bloque 5: Gestión de Usuarios, Ofertas y Seguridad

###  HU-10: Registro e Identificación de Compradores
* **Prioridad:** Must Have | **Estimación:** 3 Story Points
* **Descripción:** Como Comprador, quiero registrarme en la plataforma para ponerme en contacto con los agricultores.
* **Criterios de Aceptación (BDD):**
  * **Given** un usuario en el formulario de registro comercial.
  * **When** envía nombre, correo y tipo de comprador (*Mayorista, Minorista, Consumidor*).
  * **Then** el sistema persiste el usuario en la base de datos y le permite iniciar sesión.

---

###  HU-11: Autenticación e Inicio de Sesión (JWT)
* **Prioridad:** Must Have | **Estimación:** 3 Story Points
* **Descripción:** Como Usuario registrado, quiero iniciar sesión de forma segura para gestionar mis productos y pedidos.
* **Criterios de Aceptación (BDD):**
  * **Given** credenciales válidas enviadas a `/api/v1/auth/login`.
  * **When** el servidor valida los datos.
  * **Then** responde `200 OK` devolviendo el token de acceso JWT.

---

###  HU-12: Detalle Completo del Producto y Agricultor
* **Prioridad:** Should Have | **Estimación:** 3 Story Points
* **Descripción:** Como Comprador, quiero ver la ficha detallada de un producto para consultar descripción, fotos y predio de origen.
* **Criterios de Aceptación (BDD):**
  * **Given** una solicitud `GET` a `/api/v1/productos/{id}`.
  * **When** el producto existe en la base de datos.
  * **Then** el sistema responde con la información del lote y los datos de contacto del agricultor.

---

###  HU-13: Modificación y Cancelación de Ofertas
* **Prioridad:** Should Have | **Estimación:** 3 Story Points
* **Descripción:** Como Agricultor, quiero modificar el precio o cambiar el estado a "Agotado" cuando no tenga disponibilidad.
* **Criterios de Aceptación (BDD):**
  * **Given** un agricultor autenticado dueño de una publicación.
  * **When** actualiza la cantidad o el estado de la oferta.
  * **Then** el sistema guarda los cambios y actualiza la visibilidad en el catálogo.

---

###  HU-14: Historial de Pedidos y Guías de Transporte
* **Prioridad:** Should Have | **Estimación:** 3 Story Points
* **Descripción:** Como Usuario, quiero consultar el historial de compras/ventas pasadas para llevar control de mis operaciones.
* **Criterios de Aceptación (BDD):**
  * **Given** un usuario autenticado consultando `/api/v1/pedidos/historial`.
  * **When** solicita sus registros.
  * **Then** el sistema devuelve las órdenes realizadas con su estado, fecha y montos.

---

###  HU-15: Verificación y Moderación de Agricultores (Admin)
* **Prioridad:** Could Have | **Estimación:** 2 Story Points
* **Descripción:** Como Administrador, quiero verificar el perfil del agricultor para otorgarle una insignia de confianza.
* **Criterios de Aceptación (BDD):**
  * **Given** un usuario con rol Administrador.
  * **When** aprueba la documentación de un agricultor.
  * **Then** la cuenta recibe la insignia "Agricultor Verificado".

---

##  Resumen Estadístico del Backlog

| Categoría | Historias de Usuario | Puntos de Historia (Fibonacci) |
| :--- | :---: | :---: |
| **Must Have (Esenciales)** | HU-01, HU-02, HU-03, HU-04, HU-06, HU-10, HU-11 | 25 pts |
| **Should Have (Deseables)** | HU-07, HU-08, HU-09, HU-12, HU-13, HU-14 | 18 pts |
| **Could Have (Opcionales)** | HU-05, HU-15 | 4 pts |
| **TOTAL** | **15 Historias de Usuario** | **47 Story Points** |


# 🚀 Sprint Backlog — Sprint 1

* **Capacidad Estimada:** 9 Story Points
* **Duración del Sprint:** 2 Semanas
* **Objetivo del Sprint (Sprint Goal):** Permitir el registro de usuarios agricultores, la publicación de cosechas agrícolas y la consulta filtrada por municipio y categoría, habilitando el flujo core de oferta en la plataforma.

---

## 📌 Historias de Usuario Seleccionadas

### 🔹 HU-01: Registro de Agricultores
* **Prioridad:** Must Have | **Estimación:** 3 Story Points
* **Responsable:** Backend Developer
* **Descripción:** Como Agricultor, quiero registrarme en la plataforma para ofrecer mis productos.
* **Criterios de Aceptación (BDD):**
  * **Given** que el usuario ingresa a `/api/v1/auth/register`.
  * **When** envía un JSON con `nombre`, `ubicacion_valle` y `cedula` válida.
  * **Then** el sistema responde con un status `201 Created` y el registro persiste en la base de datos PostgreSQL.

---

### 🔹 HU-02: Publicación de Productos
* **Prioridad:** Must Have | **Estimación:** 3 Story Points
* **Responsable:** Backend Developer
* **Descripción:** Como Agricultor, quiero publicar mis cosechas para que sean visibles.
* **Criterios de Aceptación (BDD):**
  * **Given** un agricultor autenticado con token JWT.
  * **When** publica un producto con `tipo`, `cantidad` y `fecha_cosecha`.
  * **Then** el sistema valida que la fecha no sea anterior a hoy y retorna un ID de producto único.

---

### 🔹 HU-04: Búsqueda y Filtrado por Municipio y Categoría
* **Prioridad:** Must Have | **Estimación:** 3 Story Points *(Ajustado a alcance Sprint 1)*
* **Responsable:** Fullstack / Backend Developer
* **Descripción:** Como Comprador, quiero filtrar las ofertas por **Municipio** y **Categoría** para encontrar cosechas en zonas específicas.
* **Criterios de Aceptación (BDD):**
  * **Given** una petición `GET` a `/api/v1/productos/buscar` con parámetros `municipio` y `categoria`.
  * **When** el servidor procesa la consulta en PostgreSQL.
  * **Then** retorna `200 OK` con la lista filtrada de productos pertenecientes a ese municipio y categoría.

---

## Resumen de Carga de Trabajo

| Historia de Usuario | Puntos de Historia | Estado |
| :--- | :---: | :---: |
| **HU-01:** Registro de Agricultores | 3 pts | Por Hacer |
| **HU-02:** Publicación de Productos | 3 pts | Por Hacer |
| **HU-04:** Búsqueda por Municipio y Categoría | 3 pts | Por Hacer |
| **TOTAL SPRINT 1** | **9 pts** | **Comprometidos** |
