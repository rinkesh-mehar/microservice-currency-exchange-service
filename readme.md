## Microservice Spring Boot
### Naming Service
    Naming service is a service that acts as eureka server and monitor all the eureka client.
### Currency Conversion Service (client)
    Currency conversion service - Feign client is implemented in this service for default loadbalancing instead of rest template. 
### Currency Exchange Service (client)
    This application used by currency conversion service for fetching data from database.
    For loadbalancing we can run this application on to multiple ports by (vm option -> -Dserver.port=8001)