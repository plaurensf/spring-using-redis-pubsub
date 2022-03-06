# Using redis as Message Broker between services

In this application, based on [project base](https://github.com/plaurensf/spring-scaffold-project), we use
one of the different use cases that redis have, we use redis as a message broker.

This is the main architecture.

![Imgur](https://i.imgur.com/1fDpty3.png)

There we have a main application "product-application", that send a message to Redis (which act as a message broker). Then
we have two applications "customer-application" and "seller-application" that are listening for this messages in redis.
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
    │   │                       └─── SpringScaffoldProjectApplication.java
    ├───test    
    │   ├─── java
    │   │       └─── laurens
    │   │             └─── poc    
    │   │                    └─── springscaffoldproject
    │   │                       ├─── controller
    │   │                       │       └─── ProductControllerTest.java
    │   │                       └─── SpringScaffoldProjectApplicationTests.java
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

** Recomendations **

1. The structure of the project could be a little better, instead of create different projects, we could create a single project
with a global pom.xml that manage the basic dependencies, and manage the other projects like modules.

2. We could improve both publisher and subscriber projects, and including new features like connection to databases and manage the message from the publisher for doing an insert into the database or maybe include a service of any cloud provider to send message to an email for notification.

3. You should run an instance of redis before run the applications.