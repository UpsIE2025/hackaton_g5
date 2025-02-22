## Historia de Usuario: Integración de Message Bus

#### Historia Técnica
**COMO** arquitecto de software, QUIERO implementar un bus de mensajes basado en Kafka y Redis **PARA** garantizar la comunicación eficiente y en tiempo real entre microservicios.

#### Criterios de Aceptación
**DADO** que existen múltiples microservicios que necesitan comunicarse,
**CUANDO** un evento es publicado en Kafka,
**ENTONCES** los consumidores deben recibirlo de manera asíncrona y procesarlo en el orden correcto.

**DADO** que algunos eventos son altamente solicitados,
**CUANDO** un consumidor consulta un mensaje recientemente procesado,
**ENTONCES** debe obtener una respuesta rápida desde Redis en lugar de Kafka.

**DADO** que Kafka maneja eventos distribuidos,
**CUANDO** un servicio publique un evento en un tópico,
**ENTONCES** solo los consumidores suscritos a ese tópico deben recibir el mensaje.

**DADO** que el sistema debe garantizar disponibilidad y tolerancia a fallos,
**CUANDO** un nodo de Kafka o Redis falle,
**ENTONCES** el sistema debe continuar funcionando sin pérdida de eventos.

**DADO** que los mensajes deben expirar después de cierto tiempo,
**CUANDO** un evento se almacene en Redis,
**ENTONCES** debe configurarse con un TTL adecuado para evitar almacenamiento innecesario.