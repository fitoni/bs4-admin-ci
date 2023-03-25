FROM openjdk:8
EXPOSE 8080
ADD target/bs4-admin.jar bs4-admin.jar
ENTRYPOINT ["java","-jar","/bs4-admin.jar"]
