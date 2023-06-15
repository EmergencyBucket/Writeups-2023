FROM openjdk:8-bullseye

RUN apt update -y && apt install -y socat

COPY . .

RUN javac Maze.java

CMD ["socat", "TCP-LISTEN:80,reuseaddr,fork", "EXEC:\"java Maze\""]

EXPOSE 80