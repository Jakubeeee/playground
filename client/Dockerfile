FROM openjdk/15-jdk-oracle
RUN mkdir /opt/artifact
COPY target/client-1.0-SNAPSHOT.jar /opt/artifact/client.jar
EXPOSE 8080 1044
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:1044"
ARG CLIENT_ARGS
ENV CLIENT_ARGS ${CLIENT_ARGS}
CMD java --enable-preview -jar /opt/artifact/client.jar $CLIENT_ARGS