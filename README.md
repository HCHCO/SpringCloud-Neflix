# springCloud
## 项目结构
1. 基本服务
	1. BookSerice
	2. UserService
	3. BorrowSerivce
		1. 跨服务调用包(service-client)
2. 服务中间件
	1. Eureka-server(注册中间件)
	2. Hystrix-web(熔断中间件)
	3. Config-server(配置中心)
	4. gateway-server(网关)
3. 依赖包
	1. common
## 注意事项
1. 每个项目中的resource文件加需要在`application.yml`中添加数据库信息
```yaml
spring:
  datasource:
    username: root
    password: password
    url: jdbc:mysql://localhost:3306/databasename
    driver-class-name: com.mysql.cj.jdbc.Driver
```
2. 配置中心启动
	修改config-server的`application.yml`中的配置路径
```yaml
spring:  
  cloud:  
    config:  
      server:  
        git:  
          uri: file://C:/Users/Administrator/Desktop/gitclone/config-repo  
          default-label: master
```
