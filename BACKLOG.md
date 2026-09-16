# Product Backlog - AgroValle Connect 🌾

---

## 🟢 Criterios de Aceptación BDD y Clasificación MoSCoW

### HU-01: Registro e Identificación de Productores Agrícolas
* **Prioridad MoSCoW:** MUST HAVE
* **Descripción:** Como productor agrícola, quiero registrar mi perfil con datos de contacto y ubicación de finca, para ofrecer mis productos en el mercado regional.

```gherkin
Escenario: Registro exitoso de productor agrícola con datos válidos
  Dado que el usuario no autenticado ingresa al formulario de registro
  Cuando completa los campos obligatorios "Nombre", "Cédula/NIT", "Municipio" y "Teléfono"
  Y presiona el botón "Registrar Cuenta"
  Entonces el sistema crea la cuenta en estado "Pendiente de Verificación"
  Y muestra un mensaje de confirmación "Registro exitoso. Revisa tu correo".

Escenario: Intento de registro con número de identificación ya existente
  Dado que el usuario intenta registrarse con una cédula previamente dada de alta
  Cuando envía el formulario de registro
  Entonces el sistema deniega el registro
  Y despliega el error "El documento de identidad ya se encuentra registrado".
```

### HU-02: Publicación de Oferta de Cosechas
* **Prioridad MoSCoW:** MUST HAVE
* **Descripción:** Como productor verificado, quiero publicar la cantidad, tipo de cultivo y precio base por kilo, para habilitar su venta directa a compradores

```gherkin
Escenario: Publicación correcta de un lote agrícola disponible
  Dado que el productor autenticado accede al panel "Nueva Oferta"
  Cuando ingresa "Tipo de Cultivo: Tomate Chonto", "Cantidad: 500 kg" y "Precio/kg: $2.500"
  Y adjunta al menos una fotografía legible del lote
  Entonces el sistema guarda la oferta con estado "Publicado"
  Y la lista en el catálogo global de compradores.
```

### HU-03: Búsqueda y Filtrado de Productos por Municipio
* **Prioridad MoSCoW:** MUST HAVE
* **Descripción:** Como comprador comercial, quiero buscar productos agrícolas filtrando por municipio del Valle del Cauca, para optimizar costos logísticos de transporte.

```gherkin
Escenario: Filtrado de ofertas activas por ubicación geográfica
  Dado que el comprador consulta el catálogo de cosechas
  Cuando selecciona el filtro de municipio "Palmira"
  Entonces la plataforma lista únicamente las ofertas publicadas cuyo origen sea "Palmira"
  Y ordena los resultados de forma descendente por fecha de recolección.
```

### HU-04: Solicitud de Compra Directa y Negociación
* **Prioridad MoSCoW:** MUST HAVE
* **Descripción:** Como comprador, quiero enviar una propuesta formal de compra por un lote de producto, para apartar la cosecha a un precio acordado.

```gherkin
Escenario: Envío exitoso de oferta de compra sobre un lote activo
  Dado que el comprador visualiza una oferta publicada de "Cana de Azúcar"
  Cuando ingresa la cantidad requerida "200 kg" y presiona "Solicitar Compra"
  Entonces el sistema genera una orden en estado "En Negociación"
  Y notifica inmediatamente al productor vía correo electrónico.
```
### HU-01: Modulación de Perfiles y Roles de Usuario
* **Prioridad MoSCoW:** MUST HAVE
* **Descripción:** Como administrador del sistema, quiero asignar roles diferenciados (Productor, Comprador, Administrador), para controlar los accesos y permisos en la plataforma.

```gherkin
Escenario: Asignación de permisos según el rol autenticado
  Dado que un usuario con rol "Comprador" inicia sesión
  Cuando intenta ingresar a la ruta de edición de catálogo "/admin/config"
  Entonces el sistema bloquea el acceso con un código HTTP 403 Forbidden
  Y redirige al usuario a su panel de compras.
```
