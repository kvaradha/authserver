FROM adoptopenjdk/openjdk11
ARG JAR_FILE=authserver-2.7.0.jar
COPY target/${JAR_FILE} authserver.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/authserver.jar"]
