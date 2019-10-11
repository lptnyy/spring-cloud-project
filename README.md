# spring-cloud 升级为 Greenwich.RELEASE spring boot 2.1.4
### 架构图   
![Image text](image/jg.png)   
### 框架预览
(1) Eureka  
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
(11)Config Bus Rabbitmq (统一配置中心)<br/>
![Image text](image/config.png)
<br/>
(12)Gateway 代替zuul  实现了redis 限流 以及 熔断降级
<br/>
(13)ELK 将spring boot logback收集来的日志上传到日志服务ELK
![Image text](image/elk.png)<br/>
(14)TX-LCN分布式事务框架(参考pro-user-service-web)<br/>
![Image text](image/tr.png)<br/>
(15) 增加SSO 单点登录（正在整）
http://localhost:8083/oauth/token?client_id=android&client_secret=android&grant_type=password&username=admin&password=123456

### 服务配置  
注册中心 端口 8001  环境变量：eureka-service  
配置中心 端口 8002  环境变量：config-service admin-service eureka-service  
Admin管理 端口 8003 变量变量：config-service  
Zipkin 端口 8004 启动变量: config-service  
RedisService 端口 8005 启动变量：config-service
SSOService 端口 8006 启动变量：config-service
OrderService 端口 8007 启动变量：config-service  
UserService 端口 8008 启动变量：config-service  
ZuulService 端口 8101 启动变量：config-service    
TasksService 端口 8201 启动变量 config-service  