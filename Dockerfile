# Etapa 1: Construcción (Build) - Usa Maven para compilar tu código
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
# Copia los archivos necesarios para descargar dependencias
COPY pom.xml .
COPY src ./src
# Construye el archivo .jar e ignora los tests para que sea más rápido
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Run) - Usa una versión ligera de Java 21 para correr la app
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Copia solo el archivo .jar ya compilado de la etapa anterior
COPY --from=build /app/target/*.jar app.jar
# Exponemos el puerto 8081 que configuraste en tu application.properties
EXPOSE 8081
# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]