FROM openjdk:8-bullseye

RUN apt update -y && apt install -y socat

COPY . .

RUN javac App.java

CMD ["socat", "TCP-LISTEN:80,reuseaddr,fork", "EXEC:\"java App\""]

EXPOSE 80