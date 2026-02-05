FROM alpine:latest
RUN apk update && apk add --no-cache openjdk25-jre
COPY mascotas.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
