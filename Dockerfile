FROM gradle:6.7.0-jdk8

ENV wd /opt/gatling/

ADD . $wd
WORKDIR $wd
RUN gradle compileTestScala