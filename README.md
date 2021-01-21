# Arquitetura Microserviços com Spring Cloud Netflix

## Descrição

Este projeto é baseado na Arquitetura de Microsserviços, utiliza Netflix Eureka Server (Service registry) onde serão registrados os micros serviços, NetFlix Zuul (Gateway) responsável por fazer o roteamento, Service Broker(RabbitMQ) para troca de mensagens entre micros serviços,

### O que compreende este projeto:
- Arquitetura Microserviços
- Spring Cloud Netflix
- Service Discovery Netflix Eureka
- Gateway NetFlix Zuul
- Service Broker RabbitMQ
  
### Tecnologias utilizadas:
- Java 11
- Spring Boot
- Spring Security
- Spring Data
- Lombok
- Banco de dados MySql
- RabbitMQ
- Netflix Eureka
- Netflix Zuul
- Banco de dados MySql
- Docker

### Microserviços integrados:
- CRUD
- Pagamento
- RabbitMQ
- Autenticação
- Netflix Eureka Server (Service Registry)
- NetFlix Zuul - Gateway

O projeto utiliza o protocolo HTTP utilizando padrão de comunicação REST.

Para subir a aplicação devemos seguir os seguintes passos:
 ```console
git clone https://github.com/keomaklein/springCloudNetflix.git springCloudNetflix
cd springCloudNetflix
docker-compose up -d
 ```

 Para subir o projeto...