# Validation IT Service

## Design Patterns Escolhidos

### Padrão Factory

Escolhi o padrão Factory para manter o método extensível e organizado. Com ele, posso criar instâncias de validações específicas sem acoplar a lógica de criação ao código principal, facilitando a manutenção e adição de novas validações.

### Estrutura do Padrão Factory

1. **Interface de Validação**: Defino uma interface comum para todas as validações.
2. **Classes de Validação Específicas**: Implemento classes com lógicas de validação específicas.
3. **Classe Factory**: Crio uma Factory para instanciar as classes de validação conforme necessário.
4. **Caso de Uso**: Uso a Factory no caso de uso para aplicar todas as validações.

### Vantagens

- **Extensibilidade**: Adicionar novas validações é simples.
- **Manutenção**: Código modular e fácil de manter.
- **Reutilização**: Validações reutilizáveis em diferentes contextos.
- **Desacoplamento**: O código principal não precisa conhecer os detalhes das validações.

Dessa forma, mantenho a lógica de validação organizada e extensível, facilitando futuras modificações e adições de validações.

## Arquitetura

### Estrutura de Diretórios

```plaintext
src/
├── main/
│   ├── kotlin/
│   │   ├── br/
│   │   │   ├── com/
│   │   │   │   ├── validator/
│   │   │   │   │   ├── iti/
│   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   ├── ControllerExceptionHandler.kt
│   │   │   │   │   │   │   ├── ErrorDetails.kt
│   │   │   │   │   │   │   ├── ValidationController.kt
│   │   │   │   │   │   ├── exception/
│   │   │   │   │   │   │   ├── ValidatorException.kt
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   ├── DigitValidator.kt
│   │   │   │   │   │   │   ├── LengthValidator.kt
│   │   │   │   │   │   │   ├── LowerCaseValidator.kt
│   │   │   │   │   │   │   ├── RepeatCaracterValidator.kt
│   │   │   │   │   │   │   ├── SpecialCharValidator.kt
│   │   │   │   │   │   │   ├── UpperCaseValidator.kt
│   │   │   │   │   │   │   ├── Validator.kt
│   │   │   │   │   │   │   ├── ValidatorFactory.kt
│   │   │   │   │   │   │   ├── WhiteSpaceValidator.kt
│   │   │   │   │   │   ├── usecase/
│   │   │   │   │   │   │   ├── ValidationStringUseCase.kt
│   │   │   │   │   │   ├── ValidatorItiServiceApplication.kt
│   ├── resources/
│   │   ├── application.properties
├── test/
│   ├── kotlin/
│   │   ├── br/
│   │   │   ├── com/
│   │   │   │   ├── validator/
│   │   │   │   │   ├── iti/
│   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   ├── ControllerExceptionHandlerTest.kt
│   │   │   │   │   │   │   ├── ValidationControllerTest.kt
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   ├── ValidatorFactoryTest.kt
│   │   │   │   │   │   ├── usecase/
│   │   │   │   │   │   │   ├── ValidationStringUseCaseTest.kt
## Benefícios da Arquitetura em Camadas

Escolher a Arquitetura em Camadas traz vários benefícios:

- **Manutenibilidade**: A clara separação de responsabilidades facilita a manutenção e evolução do sistema.
- **Testabilidade**: Componentes desacoplados são mais fáceis de testar individualmente. Por isso, organizei meus testes de forma que cada camada tenha seus próprios testes, como `ControllerExceptionHandlerTest.kt` para a camada de apresentação e `ValidationStringUseCaseTest.kt` para a camada de aplicação.
- **Reusabilidade**: Módulos bem definidos podem ser reutilizados em diferentes partes da aplicação ou em projetos futuros.
- **Flexibilidade**: Facilita a adição de novas funcionalidades sem impactar outras partes do sistema.

Em resumo, a Arquitetura em Camadas me permite criar uma aplicação bem estruturada, fácil de manter e evoluir, ao mesmo tempo que incorpora princípios da Arquitetura Modular, garantindo que cada componente possa ser desenvolvido, testado e mantido de forma independente.


## Como Executar o Docker File

Para construir e executar a imagem Docker do projeto, siga os passos abaixo:

1. Certifique-se de que o Docker está instalado e em execução.

