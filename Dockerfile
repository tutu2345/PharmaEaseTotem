# Use uma imagem base do OpenJDK 22 (ou versão que você estiver utilizando)
FROM openjdk:22-jdk-slim

# Informações sobre o autor (incluindo os nomes e RM da equipe)
LABEL authors="Francineldo Luan Martins Alvelino -> RM: 99558, Daniel dos Santos Araujo Faria -> RM: 99067, Enzo Lafer Gallucci -> RM: 551111, Ramon Cezarino Lopez -> RM: 551279, Arthur Mitsuo Yamamoto -> RM: 551283"

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado pelo Maven para o contêiner
COPY target/pharmaease-totem.jar /app/pharmaease-totem.jar

# Exponha a porta 8080 (a mesma que sua aplicação Spring Boot usa)
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/pharmaease-totem.jar"]
