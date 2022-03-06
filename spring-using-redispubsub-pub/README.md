# Product Application - Redis as Message broker

In this application, based on [project base](https://github.com/plaurensf/spring-scaffold-project), we develop 
the publisher subject that send messages to the redis broker.

Project structure:

```
── pom.xml
── src
    ├── main    
    │   ├─── java
    │   │       └─── laurens
    │   │             └─── poc    
    │   │                    └─── springusingredispub
    │   │                       ├─── config
    │   │                       │       └─── ProductPublisherConfiguration.java
    │   │                       ├─── controller
    │   │                       │       └─── ProductController.java
    │   │                       ├─── entities
    │   │                       │       └─── Product.java
    │   │                       ├─── exceptions
    │   │                       │       ├─── ProductException.java
    │   │                       │       └─── ProductExceptionController.java
    │   │                       ├─── message
    │   │                       │       ├─── ProductData.java
    │   │                       │       └─── ProductPublisher.java
    │   │                       ├─── services
    │   │                       │       └─── ProductService.java
    │   │                       └─── SpringUsingRedisPublisherApplication.java
    ├───test    
    │   ├─── java
    │   │       └─── laurens
    │   │             └─── poc    
    │   │                    └─── springusingredispub
    │   │                       ├─── controller
    │   │                       │       └─── ProductControllerTest.java
    │   │                       └─── SpringUsingRedisPublisherApplicationTests.java
    │   └─── resources
    │           ├─── application.properties
    │           ├─── static
    │           └─── templates
               
```
Step-by-step

1. First we have to clone the base project [here](https://github.com/plaurensf/spring-scaffold-project).
2. Then, add the next Redis dependency for spring, to the pom file.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
3. Next, we have to create our publisher, in a pub/sub architecture, this is the subject
that publish or send the message to the target topic. Then, we have to create first, a 
configuration class for configure all redis stuff for messaging like, topic and the redisTemplate
object. In my case, I called the class "ProductPublisherConfiguration"

4. Then, we have to create our class which send the message to the topic, in my case I called "ProductPublisher"

5. Finally, we have finished the logic on the publisher side. Now we have to move to the subscriber side.
