FROM java-service-from-dockerfile

MAINTAINER Manan Jain "mananjain220696@gmail.com"

ENV jdbcurl=
ENV dbuser=
ENV dbpass=

WORKDIR /usr/local/bin/

ADD pma.jar .

ENTRYPOINT ["java", "-jar", "pma.jar"]