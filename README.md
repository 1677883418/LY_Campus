# 校园综合服务小程序

## 介绍

SSM+小程序练手项目，后期可能会随着学习的深入重构。(*PS*已经重构了,现在是Sring Boot版本)

小程序端地址:https://github.com/1677883418/CampusClient

## 软件架构

### 技术栈

* web开发框架:Spring Boot
* 数据库: MariaDB
* 数据持久层框架:Mybatis Mybatis-Plus
* API文档管理 : Swagger,Swagger-BootStarp
* 工具包:HuTool
* 文件存储:阿里云OSS云存储
* 依赖管理:Maven
* IDE: IntelliJ IDEA

## 使用说明

* 拉取github仓库文件
  * `git clone https://github.com/1677883418/LY_Campus.git`

* 加载maven更新(项目根目录下pom.xml)
* 修改resources目录下application.yaml文件中`active`的值(==prd  生产环境==|==dev  测试环境==),修改application-dev.yaml或application-prd.yaml中的配置信息,包括:
  * `port`	服务运行端口号
  * `datasource` 数据库连接地址、账号、密码、驱动
  * `appId|secret`微信小程序ID和密钥
  * `OSS` 云存储所需的endpoint、keyId、keySecret、bucketName等信息

* 创建campus数据库,运行根目录下sql脚本建表
* 运行application类

## 关于作者

作者个人微信，有想要一起学习的可以来哟～:

![作者微信](https://gitee.com/goodsir555/typora-Picture_bed/raw/master/img/202109161325671.png)

* 博客[记录个人成长与技术笔记]
  * https://blog.lyrw.love
* 网盘[存储学习资料，暂不开放注册]
  * https://pan.lyrw.love

