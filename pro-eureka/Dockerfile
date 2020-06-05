FROM openjdk:8u212-jre
MAINTAINER wangzhenyu@qq.com
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
COPY ${JAR_FILE} /smart/app.jar
ENTRYPOINT ["java", "-Xmx256m", "-jar", "/smart/app.jar"]
