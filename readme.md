## Microservice Spring Boot
### Naming Service
    Naming service is a service that acts as eureka server and monitor all the eureka client.
### Currency Conversion Service (client)
    Currency conversion service - Feign client is implemented in this service for default loadbalancing instead of rest template. 
### Currency Exchange Service (client)
    This application used by currency conversion service for fetching data from database.
    For loadbalancing we can run this application on to multiple ports by (vm option -> -Dserver.port=8001)
### Api Gateway 
    This microservice is a replacement of zuul gateway with spring cloud gateway.
    All the microservice registered with eureka server. 
    For all this, the gateway dependency is used that is `spring-cloud-starter-gateway`.
    This dependency provide a simple, effective way to route to API and provide cross cutting concerns to them such as security, monitoring/metrics and resiliency.
    API
    1.  http://localhost:8765/currency-conversion/currency-conversion-feign/from/USD/to/INR/quantity/2
    2.  http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR
    