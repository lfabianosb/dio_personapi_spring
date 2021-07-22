## Sistema de gerenciamento de pessoas em API REST com Spring

Desenvolvimento de uma API REST para o gerenciamento de pessoas usando Spring. Usei uma arquitetura em camadas, baseada na [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).

O arquitetura do sistema apresenta as seguintes camadas:

### Domain

- entities: objetos do domínio da aplicação
- exceptions: erro relacionados somente ao domínio


### Application

- contracts: interfaces para uso das camadas externas
- exceptions: erros relacionados à aplicação
- repositories: interface para o repositório de dados
- services: implementação dos casos de uso. Cada caso de uso representa uma regra de negócio do sistema


### Infra

- datasource: acesso aos dados através do JpaRepository
- models: modelo de dados relacionado ao banco de dados
- repositories: implementação do repositório da camada anterior


### Presentation

- controllers: endpoints que recebem as requisições do usuário
- models: modelo de dados relacionado a apresentação dos dados para o usuário
- presenters: sabe como formatar os dados para sua apresentação