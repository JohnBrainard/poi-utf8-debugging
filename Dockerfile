FROM openjdk:7-jre

VOLUME /output

COPY build/install/debugging /app

CMD /app/bin/debugging
