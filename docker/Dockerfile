# Etapa 1: Imagem base com JDK 17 e Gradle
FROM eclipse-temurin:17-jdk-jammy AS build

# Definir variáveis de ambiente
ENV GRADLE_VERSION 8.9
ENV GRADLE_HOME /opt/gradle

# Instalar dependências e Gradle
RUN apt-get update && \
    apt-get install --yes --no-install-recommends \
        wget \
        unzip \
    && wget --no-verbose --output-document=gradle.zip "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
    && unzip gradle.zip -d /opt \
    && rm gradle.zip \
    && ln -s /opt/gradle-${GRADLE_VERSION}/bin/gradle /usr/bin/gradle \
    && gradle --version  # Verifica se o Gradle foi instalado corretamente

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o código-fonte para o contêiner
COPY . .

# Inicializar um novo projeto Gradle se necessário
RUN if [ ! -f build.gradle ] && [ ! -f settings.gradle ]; then gradle init; fi

# Construir o aplicativo
RUN gradle build --no-daemon

# Etapa 2: Imagem final
FROM eclipse-temurin:17-jdk-jammy

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR compilado da etapa de build
COPY --from=build /app/build/libs/*.jar app.jar

# Comando para executar o aplicativo
CMD ["java", "-jar", "app.jar"]
