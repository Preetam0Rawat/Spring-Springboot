#Dockerfile - 1 - Creating Docker Images----------------------------
#FROM  eclipse-temurin:21-jdk
#COPY target/*.jar app.jar
#EXPOSE 5000
#ENTRYPOINT ["java","-jar","/app.jar"]


#Dockerfile - 2 - Build Jar File - Multi Stage----------------------
#FROM maven:3.9.11-eclipse-temurin-21 AS build
#WORKDIR /home/app
#COPY . /home/app
#RUN mvn -f /home/app/pom.xml clean package

#FROM eclipse-temurin:21-jdk
#EXPOSE 5000
#COPY --from=build /home/app/target/*.jar app.jar
#ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]


#Dockerfile - 3 - Caching(Optimizing Dockerfile)--------------------------------------------
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /home/app

COPY ./pom.xml /home/app/pom.xml
COPY ./src/main/java/com/in28minutes/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java \
	     /home/app/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java

RUN mvn -f /home/app/pom.xml clean package

COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM eclipse-temurin:21-jdk
EXPOSE 5000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]


