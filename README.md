# Using redis as Message Broker between services

In this application, based on [project base](https://github.com/plaurensf/spring-scaffold-project), we use
one of the different use cases that redis have, we use redis as a message broker.

This is the main architecture.

![Imgur](https://i.imgur.com/1fDpty3.png)

There we have a main application "product-application", that send a message to Redis (which act as a message broker). Then
we have two applications "customer-application" and "seller-application" that are listening for this messages in redis.
Project structure:

** Recomendations **

1. The structure of the project could be a little better, instead of create different projects, we could create a single project
with a global pom.xml that manage the basic dependencies, and manage the other projects like modules.

2. We could improve both publisher and subscriber projects, and including new features like connection to databases and manage the message from the publisher for doing an insert into the database or maybe include a service of any cloud provider to send message to an email for notification.

3. You should run an instance of redis before run the applications.