# JSON Schema CSFLE Demo Project

This project demonstrates **Client-Side Field Level Encryption (CSFLE)** support for:  
- Shared and non-shared keys  
- Schema references  
- Nested schemas  
- Schema unions  

---

## **Setup Instructions**

### 1. Configure Application Properties
- Update the application properties file located at:  
  `src/main/resources/avro/application copy.properties`
- Ensure the topic in the consumer configuration matches your desired topic to consume decrypted events.

### 2. Run the Application
Run the following command to start the application:  
```bash
mvn spring-boot:run
