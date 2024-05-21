FROM ubuntu:22.04

RUN apt-get update && apt-get install -y openjdk-21-jdk maven

WORKDIR /app

COPY . /app

RUN chmod +x /app/runner.sh

EXPOSE 8080

CMD ["/app/runner.sh"]