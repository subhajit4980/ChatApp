# Real-time Chat Application using Kafka, Spring Boot, and WebSockets

This project demonstrates how to build a simple real-time chat application using Kafka as a message broker, Java with Spring Boot for the backend, and WebSockets for real-time communication between the server and clients.

## Technologies Used

- Kafka
- Java
- Spring Boot
- WebSocket

## Installation and Setup

### Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK)
- Apache Kafka
- IDE (Eclipse, IntelliJ IDEA, or any of your choice)
- Git

### Usage
Once the backend server is running, you can connect to the chat application using your preferred frontend client. Messages sent by one user will be immediately visible to all other users.

## Before Running the Project 

*Start Zookeeper*
```shell script
zookeeper-server-start .\config\zookeeper.properties
```

*Start Kafka*
```shell script
kafka-server-start .\config\server.properties
```

*Create a Topic*
```
kafka-topics --create --topic kafka-chat --zookeeper-server localhost:9092
```
### Backend (Spring Boot)

1. Clone this repository:

   ```bash
   git clone <repository-url>
