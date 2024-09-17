# Use uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-alpine

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da aplicação para o contêiner
COPY target/desafiocartas-0.0.1-SNAPSHOT.jar /app/desafiocartas.jar

# Expor a porta padrão do Spring Boot (8080)
EXPOSE 8080

# Comando para rodar a aplicação no contêiner
ENTRYPOINT ["java", "-jar", "/app/desafiocartas.jar"]
