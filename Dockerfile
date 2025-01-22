FROM openjdk:24-oracle
MAINTAINER nisarg.panchaal@gmail.com
CMD apt install mvn
CMD mvn clean install -B -e
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]