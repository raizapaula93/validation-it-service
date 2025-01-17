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

Claro! Aqui está um exemplo de documentação escrita em Markdown para que as pessoas possam baixar e executar seu projeto Docker:

```markdown
# Validator ITI Service

Este repositório contém o serviço Validator ITI, que pode ser executado usando Docker.

## Pré-requisitos

- Docker instalado na máquina local. Você pode seguir as instruções de instalação no site oficial do Docker: [Docker Install](https://docs.docker.com/get-docker/)

## Como baixar e executar o serviço

### 1. Baixar a imagem do Docker

Para baixar a imagem do Docker, execute o seguinte comando:

```sh
docker pull raizapaula93/validator-iti-service
```

### 2. Executar o contêiner

Após baixar a imagem, você pode executar o contêiner com o seguinte comando:

```sh
docker run -d -p 8080:8080 --name validator-iti-service raizapaula93/validator-iti-service
```

Este comando faz o seguinte:

- `-d`: Executa o contêiner em segundo plano (modo "detached").
- `-p 8080:8080`: Mapeia a porta 8080 do host para a porta 8080 do contêiner.
- `--name validator-iti-service`: Dá um nome ao contêiner para facilitar a referência.
- `raizapaula93/validator-iti-service`: Nome da imagem Docker a ser executada.

### 3. Acessar o serviço

Com o contêiner em execução, o serviço estará disponível em `http://localhost:8080`.

## Comandos úteis

### Parar o contêiner

Para parar o contêiner, execute:

```sh
docker stop validator-iti-service
```

### Reiniciar o contêiner

Para reiniciar o contêiner, execute:

```sh
docker start validator-iti-service
```

### Remover o contêiner

Para remover o contêiner, execute:

```sh
docker rm validator-iti-service
```

### Verificar logs do contêiner

Para verificar os logs do contêiner, execute:

```sh
docker logs validator-iti-service
```

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
```


### Documentação Técnica para Validação de Strings

#### Descrição
Este documento fornece detalhes sobre como utilizar a API de validação de strings hospedada em uma instância EC2. A API permite que os usuários enviem strings para validação através de requisições HTTP.

#### Endpoint
- **URL Base:** `http://98.84.181.60:80`
- **Rota:** `/v1/validator-it/string`

#### Método HTTP
- **POST**

#### Cabeçalhos (Headers)
- **Content-Type:** `text/plain`

#### Corpo da Requisição (Request Body)
O corpo da requisição deve conter a string que será validada. A string deve ser enviada como texto simples (plain text).

#### Exemplo de Requisição `curl`
Você pode utilizar o comando `curl` para fazer uma requisição à API. Abaixo está um exemplo de como fazer isso:

```sh
curl --location 'http://98.84.181.60:80/v1/validator-it/string' \
--header 'Content-Type: text/plain' \
--data 'AbT!9f2ko'
```

#### Descrição dos Parâmetros
- **URL Base:** O endereço IP público da instância EC2 onde a API está hospedada.
- **Rota:** O caminho específico para o serviço de validação de strings.
- **Content-Type:** Define o tipo de conteúdo do corpo da requisição como texto simples.
- **Data:** A string que será validada pelo serviço.

#### Respostas da API
A API retornará uma resposta indicando o status da validação da string enviada. A estrutura da resposta depende do resultado da validação:

- **Validação bem-sucedida:** A resposta será um valor booleano `true`.
- **Validação falhou:** A resposta será um objeto JSON contendo um código de status, uma mensagem de erro e um valor booleano `false`.

#### Exemplos de Respostas

- **Validação bem-sucedida:**
    ```json
    true
    ```

- **Validação falhou:**
    ```json
    {
        "statusCode": 400,
        "message": "A senha não deve conter elementos repetidos",
        "status": false
    }
    ```

Este guia fornece instruções passo a passo para baixar e executar o projeto validation-it-service utilizando o IntelliJ IDEA.
P
Entendido! Vou remover a menção ao banco de dados e manter as instruções focadas na configuração e execução do projeto, bem como na verificação de cobertura de testes. Aqui está a versão revisada:

---

Instruções para Configuração do Projeto

Este guia fornece instruções passo a passo para baixar e executar o projeto validation-it-service utilizando o IntelliJ IDEA.
Pré-requisitos

    Git
    JDK (Java Development Kit) versão 17
    IntelliJ IDEA (Community ou Ultimate)
    Kotlin versão 2.1.0

Baixar o Projeto

    Abra o terminal.

    Clone o repositório do projeto utilizando o comando Git:

    git clone -b develop https://github.com/raizapaula93/validation-it-service.git

    Entre no diretório do projeto:

    cd validation-it-service

Abrir e Configurar o Projeto no IntelliJ IDEA

    Abra o IntelliJ IDEA.
    Selecione File > Open... e navegue até o diretório do projeto que você acabou de clonar.
    Escolha o diretório do projeto e clique em OK.
    O IntelliJ IDEA irá abrir o projeto e começar a importar as configurações baseadas no arquivo pom.xml.
    Aguarde até que o processo de importação e indexação esteja completo.

Configuração do JDK e Kotlin

    Certifique-se de que o JDK 17 está configurado no IntelliJ IDEA:
        Vá em File > Project Structure > Project SDK.
        Se o JDK 17 não estiver listado, clique em Add SDK > JDK e navegue até o diretório onde o JDK 17 está instalado.
        Selecione o JDK 17 e clique em OK.

    Certifique-se de que o Kotlin 2.1.0 está configurado:
        Vá em File > Settings > Plugins.
        Pesquise por "Kotlin" e certifique-se de que a versão 2.1.0 está instalada. Se não estiver, instale a versão correta.

Executar o Projeto

    Após a configuração do projeto, localize a classe principal ValidatorItiServiceApplication que contém o método main. Esta classe geralmente está marcada com o ícone do Spring Boot (uma pena verde).
    Clique com o botão direito do mouse sobre a classe ValidatorItiServiceApplication e selecione Run 'ValidatorItiServiceApplicationKt'.
    O IntelliJ IDEA irá compilar e executar o projeto.
    Verifique se o serviço Spring Boot está rodando acessando o endereço http://localhost:8080 no seu navegador ou utilizando uma ferramenta como Postman para realizar requisições HTTP.

Verificação de Cobertura de Testes

    O projeto utiliza a biblioteca JaCoCo para verificação de cobertura de testes.

    A configuração do JaCoCo está definida para uma cobertura mínima de 80%.

    Para executar os testes e verificar a cobertura, utilize os seguintes comandos no terminal dentro do diretório do projeto:

        Para limpar e executar os testes:

        mvn clean test

        Para limpar, executar os testes e gerar o relatório de verificação de cobertura:

        mvn clean verify

    Após a execução dos comandos, você pode visualizar o relatório de cobertura de testes de forma visual:
        Navegue até a pasta target/site no diretório do projeto.
        Abra o arquivo index.html em um navegador da web.
        Esse arquivo mostrará o relatório de cobertura de testes de forma visual e detalhada.

Dicas Adicionais

    Certifique-se de que o JDK correto está configurado no IntelliJ IDEA indo em File > Project Structure > Project SDK.
    Se você encontrar problemas de compilação, tente executar ./mvnw clean install no terminal dentro do diretório do projeto para construir o projeto e baixar as dependências necessárias.


