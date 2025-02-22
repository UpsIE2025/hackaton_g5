# 🚀 Proyecto de Notificaciones Punto a Punto con Kafka y Redis

## 🚀 Descripción del Proyecto

¡Bienvenido al sistema de notificaciones punto a punto! Este proyecto utiliza **Spring Boot**, **Kafka** y **Redis** para garantizar que cada mensaje sea consumido solo una vez, incluso cuando múltiples receptores estén suscritos al mismo canal. Esto asegura la entrega eficiente y sin duplicidades en un entorno distribuido.

Este proyecto es una implementación de un sistema de notificaciones punto a punto utilizando **Spring Boot**, **Kafka** y **Redis**. La arquitectura garantiza que cada mensaje sea consumido solo una vez, incluso cuando múltiples receptores están suscritos al mismo canal, optimizando así la entrega de notificaciones en un entorno distribuido.

## 👥 Historia de Usuario

En el contexto de una empresa de logística internacional, la entrega de notificaciones de estado de paquetes es crítica. Para garantizar que cada actualización sea procesada solo una vez, utilizamos un canal punto a punto con Kafka y Redis, asegurando así la eficiencia y precisión en la entrega de mensajes.

COMO **ingeniero de software en una empresa de logística internacional**,\
QUIERO **enviar notificaciones de actualizaciones de envíos a través de un canal punto a punto utilizando Kafka y Redis**\
PARA **garantizar que solo un sistema de seguimiento consuma cada notificación, evitando duplicidades y asegurando una entrega eficiente**.

### Contexto de Empresa Real

**Empresa:** DHL (empresa global de logística y envíos)\
**Necesidad:** DHL maneja millones de actualizaciones de estado de paquetes diariamente. Para garantizar que cada actualización (como "En tránsito", "Entregado" o "En aduana") sea procesada solo una vez, necesita un sistema punto a punto. Esto asegura que solo uno de sus sistemas de seguimiento o aplicaciones móviles procese cada notificación, evitando datos duplicados o inconsistentes.

## ✅ Criterios de Aceptación

Para asegurar el correcto funcionamiento del sistema, los siguientes criterios de aceptación deben cumplirse:

- **DADO** una actualización de estado enviada al canal en Kafka,\
  **CUANDO** múltiples servicios de seguimiento están suscritos al mismo canal,\
  **ENTONCES** solo uno de los servicios debe recibir y procesar la actualización.

- **DADO** un canal con múltiples actualizaciones de estado en cola,\
  **CUANDO** varios servicios están disponibles,\
  **ENTONCES** las actualizaciones deben distribuirse equitativamente, garantizando que cada una sea procesada por un único servicio.

- **DADO** una actualización procesada con éxito,\
  **CUANDO** se confirma el procesamiento,\
  **ENTONCES** Redis debe actualizar el estado para evitar reprocesamiento en otros sistemas.

- **DADO** un error en el procesamiento de una actualización,\
  **CUANDO** el servicio de seguimiento falla antes de confirmar,\
  **ENTONCES** la actualización debe permanecer en el canal para que otro servicio la procese.

## 🔧 Tecnologías Utilizadas

Este proyecto utiliza las siguientes herramientas y tecnologías:

- **Spring Boot**: Framework principal para la construcción de microservicios.
- **Apache Kafka**: Para la mensajería punto a punto, garantizando la entrega única.
- **Redis**: Para la gestión de estados de mensajes y evitar reprocesamientos.
- **Docker**: Para la contenedorización y despliegue de los servicios.

## ⚙️ Configuración del Entorno

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local:

1. Clona el repositorio:

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_PROYECTO>
   ```

2. Levanta los servicios con Docker:

   ```bash
   docker-compose up -d
   ```

3. Accede a la aplicación en tu navegador:

   ```
   http://localhost:8080
   ```

## 🤝 Contribuciones

¡Nos encantaría tu colaboración! Sigue estos pasos para contribuir al proyecto:

Si deseas contribuir:

- Realiza un fork del repositorio.
- Crea una rama con tu funcionalidad: `git checkout -b feature/nueva-funcionalidad`.
- Realiza tus cambios y haz commit: `git commit -m 'Añadir nueva funcionalidad'`.
- Envía un pull request.

## 📞 Contacto

Si necesitas más información o tienes alguna pregunta, no dudes en ponerte en contacto con el desarrollador.

Para más información, puedes contactar al desarrollador del proyecto.
