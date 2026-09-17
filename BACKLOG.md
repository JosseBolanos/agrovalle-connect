# Product Backlog - AgroValle Connect 


---

## Historias de Usuario y Criterios de Aceptación BDD

### Tabla 1. HU-01: Registro de Agricultores
Como Agricultor, quiero registrarme en la plataforma para ofrecer mis productos.
Priorización: Must
## Estimación: 3 Story Points
 Escenario BDD:
   Given que el usuario ingresa a /api/v1/auth/register.
  When envía un JSON con nombre, ubicacion_valle y cedula válida.
  Then el sistema responde con un status 201 Created y el registro persiste en la base de datos PostgreSQL.

---

### Tabla 2. HU-02: Publicación de Productos
Como Agricultor, quiero publicar mis cosechas para que sean visibles.
 Priorización: Must
 Estimación: 3 Story Points
 Escenario BDD:
   Given un agricultor autenticado con token JWT.
   When publica un producto con tipo, cantidad y fecha_cosecha.
   Then el sistema valida que la fecha no sea anterior a hoy y retorna un ID de producto único.

---

### Tabla 3. HU-03: Visualización de Precios Regionales
Como Usuario, quiero ver los precios promedio del Valle para negociar mejor.
Priorización: Must
 Estimación: 3 Story Points
 Escenario BDD:
 Given que existen 50 transacciones de "Café" en las últimas 24 horas.
 When solicito el precio promedio de "Café".
 Then el sistema calcula la media aritmética y despliega el valor exacto en pesos colombianos.

---

### Tabla 4. HU-04: Búsqueda y Filtrado por Municipio
Como Comprador, quiero filtrar los productos por municipio para reducir costos de transporte.
 Priorización: Must
 Estimación: 3 Story Points
 Escenario BDD:
 Given que existen productos publicados en diferentes municipios del Valle.
 When el comprador selecciona el municipio "Palmira" en el filtro.
 Then el sistema muestra únicamente las cosechas disponibles en "Palmira".

---

### Tabla 5. HU-05: Modulación de Roles y Permisos
Como Administrador, quiero asignar roles para restringir el acceso a funciones del sistema.
 Priorización: Must
 Estimación: 3 Story Points
 Escenario BDD:
 Given un usuario autenticado con rol "Comprador".
 When intenta ingresar a la ruta de administración `/api/v1/admin/users`.
 Then el sistema bloquea el acceso con código HTTP 403 Forbidden.

---

### Tabla 6. HU-06: Solicitud de Transporte Logístico
Como Agricultor, quiero cotizar transporte para enviar mi cosecha al comprador.
 Priorización: Should
 Estimación: 3 Story Points
Escenario BDD:
   Given una venta confirmada entre origen "Candelaria" y destino "Cali".
   When el agricultor solicita el cálculo de flete ingresando el peso en toneladas.
   Then el sistema calcula la tarifa y muestra el costo exacto del envío.

---

### Tabla 7. HU-07: Aceptación de Fletes por Transportista
Como Transportista, quiero aceptar solicitudes de transporte para gestionar la entrega.
 Priorización: Should
 Estimación: 3 Story Points
Escenario BDD:
   Given una lista de solicitudes de transporte en estado "Pendiente".
   When el transportista presiona "Aceptar Flete".
   Then el sistema asigna el envío al transportista y le entrega la dirección de recogida.

---

### Tabla 8. HU-08: Calificación de Vendedores
Como Comprador, quiero calificar al agricultor para generar confianza en la comunidad.
 Priorización: Should
 Estimación: 3 Story Points
Escenario BDD:
   Given un pedido completado y entregado con éxito.
   When el comprador envía una nota de 1 a 5 estrellas con un comentario.
   Then el sistema guarda la calificación y actualiza el promedio del agricultor.

---

### Tabla 9. HU-09: Negociación Directa de Precios
Como Comprador, quiero enviar una propuesta de compra para negociar un lote completo.
 Priorización: Should
 Estimación: 3 Story Points
Escenario BDD:
   Given un producto publicado con un precio base de $3.000 / kg.
   When el comprador propone un valor de $2.600 / kg por todo el lote.
   Then el sistema crea una contraoferta y notifica al agricultor para su aprobación.

---

### Tabla 10. HU-10: Alertas Climáticas para Cosechas
Como Agricultor, quiero recibir alertas del clima para proteger mis cultivos a tiempo.
 Priorización: Could
 Estimación: 3 Story Points
 Escenario BDD:
 Given que el servicio meteorológico detecta lluvias fuertes en "Dagua".
   When el sistema procesa el reporte del tiempo.
   Then envía una alerta a los agricultores registrados en ese municipio.

---

### Tabla 11. HU-11: Chat de Negociación Directa
Como Agricultor, quiero chatear con el comprador para acordar la entrega.
 Priorización: Should
 Estimación: 3 Story Points
Escenario BDD:
   Given una compra en proceso entre un agricultor y un comprador.
  When uno de los dos envía un mensaje en el chat.
   Then el sistema entrega el mensaje al instante en la pantalla del otro usuario.

---

### Tabla 12. HU-12: Reporte Visual de Ventas
Como Agricultor, quiero ver gráficos de mis ventas para saber cuánto he ganado.
 Priorización: Could
 Estimación: 3 Story Points
Escenario BDD:
   Given un agricultor con ventas realizadas en los últimos 3 meses.
   When ingresa a su panel de estadísticas.
   Then el sistema dibuja un gráfico con el total de dinero e ingresos por mes.

---

### Tabla 13. HU-13: Verificación de Cédula y Documentos
Como Administrador, quiero revisar los documentos del agricultor para habilitar su cuenta.
 Priorización: Must
 Estimación: 3 Story Points
Escenario BDD:
   Given una cuenta de agricultor en estado "Pendiente".
   When el administrador revisa y aprueba la cédula del usuario.
   Then la cuenta pasa a estado "Verificado" y ya puede publicar productos.

---

### Tabla 14. HU-14: Estado del Envío en Tiempo Real
Como Comprador, quiero saber dónde viene mi pedido para recibirlo a tiempo.
 Priorización: Should
 Estimación: 3 Story Points
Escenario BDD:
   Given un producto en camino con estado "En Tránsito".
   When el transportista marca la opción "Cerca al destino".
   Then el sistema manda una notificación al comprador avisando la llegada.

---

### Tabla 15. HU-15: Cancelación de Publicaciones
Como Agricultor, quiero retirar un producto si se dañó o si ya lo vendí por fuera.
 Priorización: Should
 Estimación: 3 Story Points
Escenario BDD:
   Given un producto publicado sin compras pendientes.
   When el agricultor presiona "Retirar Publicación".
   Then el sistema quita la oferta del catálogo y nadie más la puede ver.
  ---

### Tabla 16. HU-16: Historial de Transacciones e Impresión de Recibos
Como Comprador, quiero ver el historial de mis compras para descargar los recibos de pago.
 Priorización: Should
 Estimación: 3 Story Points
Escenario BDD:
   Given un comprador autenticado en la plataforma.
   When ingresa a la sección de "Mis Compras" y presiona "Descargar Recibo".
   Then el sistema genera un documento PDF con el detalle de la transacción.

---

### Tabla 17. HU-17: Recuperación y Cambio de Contraseña
Como Usuario, quiero restablecer mi contraseña por correo si la olvido para no perder el acceso.
 Priorización: Must
 Estimación: 3 Story Points
 Escenario BDD:
 Given un usuario que no recuerda su clave de acceso.
 When ingresa su correo en la opción "Olvidé mi contraseña".
 Then el sistema envía un enlace seguro con un token temporal para restablecerla.

---

### Tabla 18. HU-18: Panel de Soporte y Reporte de Problemas
Como Usuario, quiero enviar reportes de soporte cuando tenga inconvenientes con un pedido.
 Priorización: Could
 Estimación: 3 Story Points
 Escenario BDD:
 Given un usuario que experimenta un problema con un envío o pago.
 When completa el formulario de soporte con el asunto y la evidencia.
 Then el sistema genera un ticket de atención y lo asigna al equipo administrador.
