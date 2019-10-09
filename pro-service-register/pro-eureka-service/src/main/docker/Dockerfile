FROM java:8-jre
MAINTAINER wangzhenyu
ENV LANG="zh_CN.UTF-8"
RUN  ls
ADD pro-eureka-service-0.0.1-SNAPSHOT.jar pro-eureka-service.jar
ENV JAVA_OPTS="-Xms256m -Xmx512m"
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar pro-eureka-service.jar"]