FROM openjdk/15-jdk-oracle
RUN mkdir /opt/artifact
COPY target/ms-kotlin-1.0-SNAPSHOT.jar /opt/artifact/ms-kotlin.jar
EXPOSE 8080 1044
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:1044"
ARG MS_KOTLIN_ARGS
ENV MS_KOTLIN_ARGS ${MS_KOTLIN_ARGS}
CMD java --enable-preview -jar /opt/artifact/ms-kotlin.jar $MS_KOTLIN_ARGS