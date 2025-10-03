# Dockerfile
FROM openjdk:17-jdk-slim

# Directorio de trabajo
WORKDIR /app

# Copiar el JAR generado por Maven
COPY target/*.jar app.jar

# Puerto expuesto (opcional)
EXPOSE 8080

# Comando para correr la app
ENTRYPOINT ["java", "-jar", "app.jar"]
