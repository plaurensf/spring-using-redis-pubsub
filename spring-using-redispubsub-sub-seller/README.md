# Seller Application - Redis as Message broker

This is the Seller-application. It is subscribed to redis, and it is listening the topic.

Project structure:

```
── pom.xml
── src
    ├── main    
    │   ├─── java
    │   │       └─── laurens
    │   │             └─── poc    
    │   │                    └─── springscaffoldproject
    │   │                       ├─── config
    │   │                       │       └─── DriverConfiguration.java
    │   │                       ├─── entities
    │   │                       │       └─── Product.java
    │   │                       ├─── message
    │   │                       │       ├─── ProductData.java
    │   │                       │       └─── ProductSubscriber.java
    │   │                       └─── SpringUsingRedispubsubSubSellerApplication.java
    ├───test    
    │   ├─── java
    │   │       └─── laurens
    │   │             └─── poc    
    │   │                    └─── springscaffoldproject
    │   │                       └─── SpringUsingRedispubsubSubSellerApplicationTests.java
    │   └─── resources
    │           ├─── application.yml
    │           ├─── static
    │           └─── templates
               
```
Step-by-step

1. First, add the next Redis dependency for spring, to the pom file.
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
2. Next, we have to create our config driver, the class which configure the RedisMessageListenerContainer.

3. Then, we need a class that implements MessageListener interface and override the "onMessage" method, this method 
is called when the publisher send a message to the message broker.

4. Finally, we print the received message in console.