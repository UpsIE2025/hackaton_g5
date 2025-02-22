## Historia de Usuario: Integración de Command Message

#### Historia Técnica
**COMO** desarrollador de integración,
**QUIERO** implementar un sistema de mensajería basado en Kafka y Redis para enviar y procesar comandos entre microservicios
**PARA** garantizar la invocación confiable de procedimientos en otras aplicaciones.

#### Criterios de Aceptación
**DADO** que un servicio necesita invocar un procedimiento en otro sistema,
**CUANDO** publique un mensaje de comando en Kafka,
**ENTONCES** el servicio destino debe recibir y procesar el comando correctamente.

**DADO** que la entrega del mensaje debe ser confiable,
**CUANDO** un consumidor procese un comando,
**ENTONCES** debe asegurarse de confirmar la recepción antes de eliminarlo del tópico.

**DADO** que algunos comandos pueden ser recurrentes o requerir reintentos,
**CUANDO** un mensaje de comando sea consumido y detecte una falla temporal,
**ENTONCES** debe reintentarse según la política de reintentos configurada.

**DADO** que el rendimiento del sistema es crítico,
**CUANDO** un servicio consulte un comando reciente,
**ENTONCES** debe obtenerlo desde Redis en lugar de volver a Kafka si está dentro del TTL configurado.

**DADO** que los comandos pueden tener distintos tipos y estructuras,
**CUANDO** se publique un mensaje en Kafka,
**ENTONCES** debe incluir metadatos que permitan al consumidor interpretar y ejecutar el procedimiento correctamente.