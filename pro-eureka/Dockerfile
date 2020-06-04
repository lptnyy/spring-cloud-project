FROM openjdk:8u212-jre
MAINTAINER wangzhenyu@qq.com
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
COPY target/smart-config-1.0-snapshot.jar /smart/smart-config-1.0-snapshot.jar
ENTRYPOINT ["java", "-Xmx256m", "-jar", "/smart/smart-config-1.0-snapshot.jar"]
