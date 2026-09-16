# Definition of Done (DoD) - AgroValle Connect 📋

Para que una Historia de Usuario (HU) sea considerada **"Hecha" (Done)** y aceptada dentro del incremento del Sprint, debe cumplir obligatoriamente con todos los criterios evaluativos descritos a continuación:

---

## 1. 💻 Calidad de Código y Desarrollo
- [ ] El código cumple con los estándares de estilo y buenas prácticas establecidos por el equipo.
- [ ] Todo el código nuevo ha sido revisado y aprobado mediante al menos un **Pull Review / Peer Review** por otro integrante del equipo.
- [ ] No existen fragmentos de código duplicado, variables sin uso ni comentarios innecesarios o residuales.
- [ ] El código fue subido a la rama correspondiente y fusionado (*merged*) correctamente en la rama principal (`main`).

---

## 2. 🧪 Pruebas y Criterios de Aceptación (BDD)
- [ ] Todos los escenarios descritos bajo el formato BDD (Gherkin: *Dado/Cuando/Entonces*) en el Product Backlog han sido probados y validados con éxito.
- [ ] Se ejecutaron pruebas unitarias e integrales sin fallas ni errores en la consola.
- [ ] El flujo funcional completo no presenta errores que bloqueen la experiencia del usuario (Bugs de prioridad Alta o Crítica).

---

## 3. 🎨 Interfaz y Experiencia de Usuario (UI/UX)
- [ ] La interfaz gráfica responde correctamente en dispositivos móviles y de escritorio (*Responsive Design*).
- [ ] Los formularios contienen validaciones visibles para el usuario en caso de datos faltantes o erróneos.
- [ ] Los tiempos de carga y respuesta de la interfaz son óptimos para conexiones locales.

---

## 4. 📚 Documentación y Repositorio
- [ ] Los cambios significativos en arquitectura, APIs o modelos de datos han sido documentados en la carpeta `docs/`.
- [ ] Los commits realizados en Git siguen un mensaje claro y descriptivo (ej. `feat: agregar registro de usuario`).
- [ ] El archivo `README.md` se encuentra actualizado si la nueva funcionalidad requiere configuración previa o nuevas dependencias.

---

## 5. 🚀 Despliegue y Aceptación
- [ ] La funcionalidad está desplegada y funcional en el entorno de pruebas/desarrollo local.
- [ ] El **Product Owner** o líder de equipo ha verificado la funcionalidad y dado su visto bueno para el cierre de la historia.

---

## ✍️ Firma y Conformidad del Equipo de Desarrollo

Al incorporar este documento al repositorio, los integrantes del equipo declaran haber leído, comprendido y aceptado la presente **Definition of Done (DoD)** como la norma oficial de calidad para la entrega de cada Historia de Usuario en **AgroValle Connect**:

| Nombre del Integrante | Rol en el Proyecto | Estado / Firma |
| :--- | :--- | :--- |
| **Josse Manuel Bolaños** | Lead Developer / Frontend | ✅ Firmado |
| **Michael robayos** | Product Owner / Backend | ✅ Firmado |
| **Emanuel vidal** | Scrum Master / QA | ✅ Firmado |

*Fecha de formalización: 16 de septiembre de 2026*
