FROM gtbanf1979/maven:v1
USER 0
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN apt-get install -y curl
COPY target/actuator-demo-0.0.1-SNAPSHOT.jar /usr/src/app





#ENTRYPOINT ["java","-jar","/usr/src/app/actuator-demo-0.0.1-SNAPSHOT.jar"]
CMD ["java","-jar","/usr/src/app/actuator-demo-0.0.1-SNAPSHOT.jar"]
