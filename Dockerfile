FROM openjdk:11
ADD target/myBlogBD-0.0.1-SNAPSHOT.jar myBlogBD-0.0.1-SNAPSHOT.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "myBlogBD-0.0.1-SNAPSHOT.jar"]