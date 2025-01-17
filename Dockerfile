# Usar a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Criar um diretório para a aplicação
WORKDIR /app

# Copiar o arquivo JAR para o contêiner
COPY target/validator-iti-service-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que a aplicação vai usar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
