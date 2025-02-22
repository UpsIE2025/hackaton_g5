# Message Channel / Invalid Message  🛠️

### Descripción

Historia de usuario para realizar un productor y un consumidor, con la finalidad de verificar la validez
de los mensajes generados.

**COMO** administrador del sistema de mensajería,
**QUIERO** definir uno o más canales de mensajes no válidos,
**PARA** gestionar los mensajes que no puedan ser procesados por sus receptores.

### Criterios de Aceptación

1. El receptor debe identificar los mensajes incorrectos.

2. Los mensajes no válidos deben moverse a un canal especial.

3. El administrador debe poder configurar los canales de mensajes no válidos.

4. Se debe proporcionar un mecanismo para analizar y depurar estos mensajes.

### Notas Técnicas

1. Se implementará un canal invalid_messages en Redis.

2. Los consumidores verificarán la validez del mensaje antes de procesarlo.

3. Los mensajes no válidos serán registrados para su posterior análisis.