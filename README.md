spring-boot-microservices -  Learning the Basic of Spring Cloud 
============================================

Copyright (c) 2019, [WaheedTechblog](http://www.waheedtechblog.com/).

Contributor: Abdul Waheed [abdulwaheed18@gmail.com]

[https://github.com/abdulwaheed18/spring-boot-microservices](https://github.com/abdulwaheed18/spring-boot-microservices)

**spring-boot-microservices** will covers most of the spring cloud fundamentals.

## Topic covered  <-->  Application Mapped
- Spring Hystix - Product Service
- Spring Eureka Server - Discovery Server
- Spring Feign Client - Product Service
- Spring Ribbon (Load Balancer) - Product Service
- Spring Zuul Server - Api Gateway
- Spring Sleuth - Configured in all applications
- Spring Zipkin Server - link provided to download zipkin server jars

## Pending Items
- Spring cloud Config
- Bus setup
- ELK Setup
  - Architecture Diagram (How each application connect to each other)

## Sequence wise description (Please start the application in the same sequence)

### 1. Discovery-Server
      Eureka Server is a severn where each microservice application will register and deregister itself at the time of starts up and removal.
      Once you start the application, hit http://localhost:8761/ to check Eureka Server UI.
       More detail can be found over here: http://www.waheedtechblog.com/2019/08/microservices-service-registry-and.html

### 2. Zipkin Server
      Please check this [link](https://github.com/openzipkin/zipkin/tree/master/zipkin-server) to download and setup zipkin server on your local instance.
      It will show logs of each micro services at a centralized location.

### 3. Zuul API Gateway
      Zuul API server will acts as a gateway for each of your micro services application. Using API Gateway, you don't need to expose all your endpoint to the outer world and Authentication, Monitoring, logging can be done at centralized location.
      Start the server and hit http://localhost:7005/product/products/1 endpoint once all your application are up and running.

### 4. Price-service
      Simple Web application exposing one rest API. To check how load balancing work, Start this application on multiple ports like 7002,8002,8003 and so on.
      Default URL: http://localhost:7002/prices/{id}

### 5. Product-service
      product-service demonstarte how can we integrate circuit-breaker in spring boot application.Product Service internally invokes Price Service and If there are multiple pirce-service application are running then Ribbon will divide the load equally 
       URL: http://localhost:7001/products/{id}
       Read below articles on how Hystix and Ribbon works and why Discovery server is important here
      - http://www.waheedtechblog.com/2019/06/circuit-breaker-and-microservices.html
       - http://www.waheedtechblog.com/2019/06/netflix-hystrix-circuit-breaker.html
       - http://www.waheedtechblog.com/2019/08/microservices-spring-cloud-ribbon-with.html 

### 6. Feign Client
      Just another example to show how to communicate between micro services using Feign Client.
       URL: http://localhost:7003/feign/{id}
