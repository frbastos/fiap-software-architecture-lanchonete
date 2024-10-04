# Estágio 1: Construir o JAR
FROM eclipse-temurin:17-jdk-jammy AS build

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /home/gradle/project

# Copiar todos os arquivos do projeto para o contêiner
COPY . .
# Isso deve funcionar se você estiver no diretório correto

# Adicionar permissão de execução ao script gradlew
RUN ls -la && chmod +x gradlew && ls -la

# Verificar line endings e converter se necessário
RUN apt-get update && apt-get install -y dos2unix && dos2unix gradlew

# Executar o comando de build do Gradle
RUN ./gradlew build --no-daemon

# Estágio 2: Construir a imagem final
FROM eclipse-temurin:17-jdk-jammy

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o JAR construído no estágio anterior para o diretório de trabalho
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

# Definir o comando para executar o aplicativo
ENTRYPOINT ["java","-jar","/app/app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]

# Expor a porta que a aplicação vai usar
EXPOSE 8080
