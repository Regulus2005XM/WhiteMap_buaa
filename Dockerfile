# UbuntuOS
FROM ubuntu:20.04
ENV DEBIAN_FRONTEND=noninteractive

# 后端Maven java MySQL Nginx
RUN apt-get update && \
    apt-get install -y \
    curl \
    wget \
    gnupg2 \
    openjdk-11-jdk \
    maven \
    mysql-client \
    nginx \
    build-essential

# 安装 Node.js 和 npm
RUN curl -sL https://deb.nodesource.com/setup_14.x | bash - && \
    apt-get install -y nodejs

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . .
RUN npm install

# 暴露服务端口
EXPOSE 3306
EXPOSE 80
COPY nginx.conf /etc/nginx/nginx.conf

# 安装 MySQL 数据库
RUN apt-get install -y mysql-server && \
    service mysql start && \
    mysql -e "CREATE DATABASE example_db;"

# 执行 Maven 命令打包 Spring Boot 应用
RUN mvn clean package

CMD service nginx start && tail -F /var/log/nginx/access.log