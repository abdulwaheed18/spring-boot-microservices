spring-boot-microservices-  Learning the Basic of Spring Cloud 
============================================

Copyright (c) 2019, [WaheedTechblog](http://www.waheedtechblog.com/).

Contributor: Abdul Waheed [abdulwaheed18@gmail.com]

[https://github.com/abdulwaheed18/spring-boot-microservices](https://github.com/abdulwaheed18/spring-boot-microservices)

Check all projects to get in more depth details.

**spring-boot-microservices** will covers most of the spring cloud fundamentals.

## 1. product-service
      product-service demonstarte how can we integrate circuit-breaker in spring boot application.Product Service internally invokes Price Service.
      URL: http://localhost:7001/products/{id}
  
## 2. price-service
      Simple Web application exposing one rest API.
      URL: http://localhost:7002/prices/{id}
      
## 3. Discovery-Server
      Eureka Server application where each client application will register and deregister at the time of starts up and removal.
      
## 4. Feign Client
      Just another example to show how to communicate between microservices using Feign Client.
      URL: http://localhost:7003/feign/{id}
