FROM eclipse-temurin:17 AS builder

RUN apt update && apt upgrade -y && apt install -y maven && \
    apt remove --auto-remove python -y && apt-get purge python -y && \
    apt-get update


COPY pom.xml pom.xml

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean package -DskipTests=true

FROM eclipse-temurin:17

RUN apt update && apt upgrade -y && apt install -y locales && \
    apt remove --auto-remove python -y && apt-get purge python -y && \
    apt-get update

ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --FROM=builder /target/*.jar /app.jar

CMD ["java", "-jar", "/app.jar"]

