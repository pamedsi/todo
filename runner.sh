#!/bin/bash

mvn clean package -Dmaven.test.skip=true
java -jar target/todo-0.0.1-SNAPSHOT.jar