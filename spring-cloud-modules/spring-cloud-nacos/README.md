1.创建数据库
CREATE DATABASE demo DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
2.创建表
导入user sql ，或直接创建

3.启动nacos
导入到nacos_config_export_20220601114023.zip
或直接创建，spring-cloud-nacos-dev.yml 内容就是文档里面的内容。
4.配置nacos 地址
在bootstrap.yml 中修改
5.启动项目

6.浏览器访问
访问http://localhost:1991/
结果
"12[User(id=1, username=1, password=2)]"---hello

cloud 版本是
Hoxton.SR8

通过他的底层来判断使用spring-boot的版本2.3.7.RELEASE