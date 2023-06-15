FROM openjdk:8-bullseye

RUN apt update -y && apt install -y socat

COPY . .

ENV FLAG=bucket{D35T1NY_F0M0_0c0f34b03}

RUN javac Main.java

CMD ["socat", "TCP-LISTEN:80,reuseaddr,fork", "EXEC:\"java Main\""]

EXPOSE 80