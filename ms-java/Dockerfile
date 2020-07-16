FROM adoptopenjdk/openjdk14
RUN mkdir /opt/artifact
COPY target/ms-java-1.0-SNAPSHOT.jar /opt/artifact/ms-java.jar
EXPOSE 8080 1044
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:1044"
ARG MS_JAVA_ARGS
ENV MS_JAVA_ARGS ${MS_JAVA_ARGS}
CMD java --enable-preview -jar /opt/artifact/ms-java.jar $MS_JAVA_ARGS