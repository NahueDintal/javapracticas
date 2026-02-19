#FROM alpine:latest
#RUN apk update && apk add --no-cache openjdk25-jre
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY dist/cerrajeria.jar /app/cerrajeria.jar
CMD ["java", "-jar", "cerrajeria.jar"]

