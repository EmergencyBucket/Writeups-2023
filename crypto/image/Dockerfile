FROM maven:3.9.1-eclipse-temurin-8

COPY . .

ENV FLAG=bucket{x0r_15_n0t_s4f3_10a87a0b3}

RUN mvn clean package

CMD ["java", "-jar", "./target/image_hard-1.0.jar"]

EXPOSE 80