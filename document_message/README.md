# ?? Kafka Document Message Pattern with Spring Boot

Este proyecto implementa el **Patr車n de Integraci車n Empresarial (EIP) "Document Message"** utilizando **Apache Kafka** y **Spring Boot**.  
El sistema permite enviar y recibir **mensajes estructurados** en formato JSON, asegurando un intercambio de informaci車n completo y desacoplado entre sistemas.

---

## ?? **Arquitectura**
?? **Patr車n utilizado: Document Message**
- Se env赤an mensajes con **informaci車n estructurada** (JSON).
- El consumidor recibe **documentos completos** y los procesa sin necesidad de hacer m芍s consultas.

?? **Componentes**  
1?? **Kafka Producer** ↙ Publica 車rdenes en un **topic Kafka** (`orders`).  
2?? **Kafka Consumer** ↙ Escucha el topic y procesa las 車rdenes.  
3?? **Modelo de Orden** ↙ Define la estructura JSON del mensaje.

---

## ?? **Requisitos Previos**
- Docker y Docker Compose  
- Java 17+  
- Gradle 8+  
- Apache Kafka

---

### 1?? **Clonar el repositorio**
git clone https://github.com/UpsIE2025/hackaton_g5.git


?? Proyecto: Implementaci車n del Patr車n Document Message con Kafka y Redis as broker

?? Historia de Usuario

COMO arquitecto de software,QUIERO desarrollar un sistema de mensajer赤a basado en el patr車n Document Message utilizando Kafka, Redis y Java con Gradle,PARA garantizar la comunicaci車n eficiente y as赤ncrona entre los microservicios del sistema.

? Criterios de Aceptaci車n

?? Publicaci車n de Mensajes en Kafka

DADO un microservicio productor configurado en Java con Gradle,

CUANDO se genere un evento de negocio con datos estructurados en JSON,

ENTONCES el mensaje debe enviarse correctamente a un t車pico en Kafka.

?? Consumo de Mensajes desde Kafka

DADO un microservicio consumidor suscrito al t車pico en Kafka,

CUANDO se publique un mensaje con informaci車n en formato JSON,

ENTONCES el consumidor debe procesarlo y almacenarlo en Redis.

?? Almacenamiento en Redis

DADO un mensaje recibido desde Kafka,

CUANDO se procese correctamente por el consumidor,

ENTONCES debe guardarse en Redis para su posterior recuperaci車n.

?? Visualizaci車n de Mensajes en Redis Commander

DADO que los mensajes han sido almacenados en Redis,

CUANDO se acceda a Redis Commander a trav谷s de http://localhost:8081,

ENTONCES se deben visualizar los mensajes almacenados en Redis.

?? Configuraci車n de Docker Compose

DADO un entorno de contenedores con Kafka y Redis,

CUANDO se ejecute docker-compose up -d,

ENTONCES los servicios deben levantarse correctamente y ser accesibles en sus respectivos puertos.

?? Tecnolog赤as Utilizadas

Java 17+

Gradle

Apache Kafka

Redis as broker

Docker & Docker Compose

Spring Boot (para la implementaci車n de los microservicios)

?? Instalaci車n y Ejecuci車n

Clonar el Repositorio

git clone https://github.com/tu_usuario/tu_proyecto.git
cd tu_proyecto

Levantar los Servicios con Docker Compose

docker-compose up -d

Compilar y ejecutar la aplicaci車n

./gradlew bootRun

Verificar Kafka (opcional)

docker exec -it broker kafka-topics.sh --bootstrap-server localhost:9092 --list

Acceder a Redis Commander

Abrir el navegador en http://localhost:8081

?? Notas

Aseg迆rate de tener Docker y Docker Compose instalados.

Los puertos utilizados en este proyecto son:

Kafka: 9092

Redis: 6379

Redis Commander: 8081

?? Contribuciones

Las contribuciones son bienvenidas. Para cualquier mejora o sugerencia, abre un issue o env赤a un pull request.

?? Contacto: jespinozac10@est.ups.edu.ec

?? Happy Coding! ??

