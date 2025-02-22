# Message Channel / Datatype  🛠️

### Descripción

Historia de usuario para realizar un productor y un consumidor, con la finalidad de verificar los
tipos de datos y direccionar a un canal adecuado.

**COMO** desarrollador,
**QUIERO** utilizar un canal de tipo de datos separado para cada tipo de datos,
**PARA** asegurarme de que todos los datos en un canal específico sean del mismo tipo.

### Criterios de Aceptación

1. El remitente debe identificar el tipo de dato antes de enviarlos.

2. El remitente debe seleccionar el canal apropiado basado en el tipo de dato.

3. El receptor debe recibir los datos en el canal adecuado.

4. El receptor debe saber el tipo de datos según el canal donde fueron recibidos.

### Notas Técnicas

1. Se implementará un sistema de mensajería basado en Redis.

2. Cada tipo de dato tendrá un canal específico en Redis.

3. Se usarán patrones de publish/subscribe para distribuir los mensajes de manera eficiente.

4. Se validará que cada canal solo reciba datos del tipo esperado.