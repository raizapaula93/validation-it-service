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

(Descreva a arquitetura do projeto, como ele está organizado, quais são os principais componentes, camadas, etc.)

## Como Executar o Docker File

Para construir e executar a imagem Docker do projeto, siga os passos abaixo:

1. Certifique-se de que o Docker está instalado e em execução.
2. Navegue até o diretório raiz do projeto onde o Dockerfile está localizado.
3. Construa a imagem Docker:
   ```sh
   docker build -t nome-da-imagem .
