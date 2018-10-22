# src-jz-cloud

#### 项目介绍
1. 简单的spring cloud项目，包含非spring boot项目注册与发现。
2. 其中使用ribbon提供了随机重定向到遗留的Java Web项目。

#### 软件架构
1. spring boot.
2. spring cloud.
    eureka
    feign
    ribbon
    zuul


#### 安装教程
IDEA :
1. file > open
    选择src-jz-cloud项目中的pom.xml文件即可。

#### 使用说明
1. eureka-server
    注册与发现
2. server-feign
    feign[负载均衡]，支持ribbon，断路器
3. server-hi
    服务提供
4. server-ribbon
    负载均衡，断路器
5. server-zuul
    路由选择