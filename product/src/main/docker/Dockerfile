FROM java:8

# environment
EXPOSE 8080

# executable
ADD @project.artifactId@-@project.version@.jar app.jar

# create group
RUN groupadd service
RUN chgrp service app.jar

# create user
RUN useradd -ms /bin/bash -G service booter
USER root
WORKDIR /home/booter
RUN mkdir gen/

#install mysql client
RUN echo "deb [check-valid-until=no] http://cdn-fastly.deb.debian.org/debian jessie main" > /etc/apt/sources.list.d/jessie.list
RUN echo "deb [check-valid-until=no] http://archive.debian.org/debian jessie-backports main" > /etc/apt/sources.list.d/jessie-backports.list
RUN sed -i '/deb http:\/\/deb.debian.org\/debian jessie-updates main/d' /etc/apt/sources.list
RUN bash -c "apt-get -o Acquire::Check-Valid-Until=false update"
RUN bash -c "apt-get install mysql-client -y"
RUN bash -c "apt-get install libmysql-java -y"

# run app as user 'root'
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Xmx256m", "-Xss32m", "-Djava.security.egd=file:/dev/./urandom", "-Djava.net.preferIPv4Stack=true","-jar","/app.jar"]
