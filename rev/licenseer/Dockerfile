FROM golang:bullseye

RUN apt update -y && apt install -y socat

WORKDIR /app
COPY go.mod ./

RUN go mod download

COPY *.go ./

RUN go build -o /out/main

ENV FLAG="bucket{HASH1NG_IS_S0_FUN_2f47d31e7c28d}"

CMD ["socat", "TCP-LISTEN:80,reuseaddr,fork", "EXEC:\"/out/main\""]

EXPOSE 80
