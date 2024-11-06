# WhiteMap_buaa 北航白泽网
服务器端口：https://82.157.31.31/ <br/>
服务器域名：https://baizemap.icu/<br/>
项目架构：采用B/S浏览器-服务器架构，MVC架构开发<br/>
技术栈分为四个部分：前端+后端+数据库+服务器<br/>
Maven进行项目管理，Git进行分布式版本控制<br/>
>注：~~删除线~~ 代表还尚引入的功能，不保证最后一定加入本项目中。
### 第一部分 Vue3 前端 
##### localhost:5173
![vue](./WhiteVue3/public/favicon.ico)
在Vue-Cli脚手架上搭建，由HTML5+CSS3负责页面展示，<br/>
TypeScript(JavaScript)负责脚本控制，<br/>
使用了ElementPlus的UI库，BaiduMap的API，<br/>
由Vue-Router进行路由管理，Pinia进行状态管理，<br/>
Axios进行异步通信，向后端发送HTTP请求。
### 第二部分 SpringBoot3 后端 
##### localhost:8080
使用了Java17的框架SpringBoot3完成IoC和AOP功能，<br/>
文件架构：<br/>
|—— controller类：接收HTTP请求，发出HTTP响应；<br/>
|—— service类：完成基本的业务逻辑；<br/>
|—— mapper类：执行SQL语句，与数据库交互；<br/>
在src/main/resources/application.properties中配置数据库的方法示例：
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/db001
spring.datasource.username=root
spring.datasource.password=12345678
```
~~SpringSecurity+OAuth2.0负责安全管理和登录验证~~<br/>
由MyBatisPlus进行数据库操作。
### 第三部分 MySQL 数据库
##### localhost:3306
访问服务器远程MySQL库：`>mysql -h82.157.31.31 -uroot -p`
>注意：服务器内存较小(我没钱:D)，数据库开发测试请使用本地MySQL
### 第四部分 Nignx 服务器
在Linux服务器上使用宝塔面板进行部署。<br/>
使用Nignx进行反向代理/负载均衡。<br/>
~~借助Redis分布式缓存和RabbitMQ消息队列优化服务器性能。~~