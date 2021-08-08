## People management system with API REST using Spring

API REST for people management system using Spring Framework. Design based on [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).

The system was divided into following layers:

### Domain

- entities: domain objects
- exceptions: errors related to domain


### Application

- exceptions: errors related to application
- repositories: interface to repository (implemented by infra layer)
- services: use case implementation. The use cases represent business rules


### Infra

- datasource: data access using JpaRepository
- models: data models representing database tables
- repositories: implementation of repository from application layer


### Presentation

- controllers: API endpoints. They handle HTTP requests. Presenters and Controllers are the same class
- models: data models representing how data should be returned