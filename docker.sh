#!/bin/sh
docker build -t 192.168.1.83:5000/repository/springboot-green:v2 .
docker tag 192.168.1.83:5000/repository/springboot-green:v2 gtbanf1979/maven:green3
docker push 192.168.1.83:5000/repository/springboot-green:v2
docker push gtbanf1979/maven:green3
