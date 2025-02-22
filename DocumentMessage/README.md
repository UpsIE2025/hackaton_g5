# 📦 Kafka Document Message Pattern with Spring Boot

Este proyecto implementa el **Patrón de Integración Empresarial (EIP) "Document Message"** utilizando **Apache Kafka** y **Spring Boot**.  
El sistema permite enviar y recibir **mensajes estructurados** en formato JSON, asegurando un intercambio de información completo y desacoplado entre sistemas.

---

## 🏗 **Arquitectura**
📌 **Patrón utilizado: Document Message**
- Se envían mensajes con **información estructurada** (JSON).
- El consumidor recibe **documentos completos** y los procesa sin necesidad de hacer más consultas.

📌 **Componentes**  
1️⃣ **Kafka Producer** → Publica órdenes en un **topic Kafka** (`orders`).  
2️⃣ **Kafka Consumer** → Escucha el topic y procesa las órdenes.  
3️⃣ **Modelo de Orden** → Define la estructura JSON del mensaje.

---

## 📌 **Requisitos Previos**
🔹 Docker y Docker Compose  
🔹 Java 17+  
🔹 Gradle 8+  
🔹 Apache Kafka

---

### 1️⃣ **Clonar el repositorio**
git clone https://github.com/UpsIE2025/hackaton_g5.git

