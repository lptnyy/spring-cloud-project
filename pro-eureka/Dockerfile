FROM openjdk:8u212-jre
MAINTAINER wangzhenyu@qq.com
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
COPY target/${project.build.finalName}.jar /smart/${project.build.finalName}.jar
ENTRYPOINT ["java", "-Xmx256m", "-jar", "/smart/${project.build.finalName}.jar"]
