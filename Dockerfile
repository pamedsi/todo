FROM ubuntu:22.04

RUN apt-get update && apt-get install -y openjdk-21-jdk maven dos2unix

WORKDIR /app

COPY . /app

RUN dos2unix /app/runner.sh
RUN chmod +x /app/runner.sh

EXPOSE 8080

CMD ["/app/runner.sh"]