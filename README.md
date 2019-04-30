# spring-cloud 升级为 Greenwich.RELEASE spring boot 2.1.4
(1) Eureka
<br/>
![Image text](https://freenetfile.oss-ap-southeast-1.aliyuncs.com/WeChat%20Screenshot_20181206145421.png)
<br/> 
(2) Actuator
<br/>
(3) Feign Ribbon
<br/>
(4) Swagger2
<br/>
(5) Hystrix
<br/>
(6) MyBatis druid
<br/>
(7) Redis
<br/>
(8) Zuul
<br/>
(9) Sleuth zipkin rabbitmq mysql持久
![Image text](https://freenetfile.oss-ap-southeast-1.aliyuncs.com/WeChat%20Screenshot_20181206145435.png)
<br/>
![Image text](https://freenetfile.oss-ap-southeast-1.aliyuncs.com/WeChat%20Screenshot_20181206145445.png)
<br/>
(10) Admin
<br/>
![Image text](https://freenetfile.oss-ap-southeast-1.aliyuncs.com/WeChat%20Screenshot_20181207113300.png)
<br/>
![Image text](https://freenetfile.oss-ap-southeast-1.aliyuncs.com/WeChat%20Screenshot_20181207112551.png)
<br/>
(11)Config Bus Rabbitmq 配置中心执行post请求 http://wangzhenyu-pc:13001/actuator/bus-refresh
<br/>
(12)Gateway 代替zuul  实现了redis 限流 以及 熔断降级
<br/>
(13)ELK 将spring boot logback收集来的日志上传到日志服务ELK
![Image text](image/elk.png)
<br/> docker 安装elk
<br/>
安装命令：docker run -i -t -p 5601:5601 -p 9200:9200 -p 5044:5044 -e ES_MIN_MEM=128m -e ES_MAX_MEM=1024m -it --name elk22 sebp/elk
<br/>
通过docker exec -it 容器ID /bin/bash  进入容器 修改 Logstash 配置文件  目录 /opt/logstash/config/logstash-sample.conf
<br/>
修改内容：
<br/>
    # Sample Logstash configuration for creating a simple
    <br/>
    # Beats -> Logstash -> Elasticsearch pipeline.
    
    input {
      tcp {
        port => 5044
        codec => json_lines
      }
    }
    
    output {
      elasticsearch {
        hosts => ["http://localhost:9200"]
        index => "%{[appName]}-%{+YYYY.MM.dd}"
        #user => "elastic"
        #password => "changeme"
      }
      stdout{ codec => rubydebug }
    }
<br/>
    修改完成之后 重启容器
 