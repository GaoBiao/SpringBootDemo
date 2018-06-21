# SpringBootDemo
基于SpringBoot的webDemo<br>
IDE:MyEclipse 2017<br>
JAVA环境:jdk8<br>
数据库环境:MySql<br>
项目管理工具:maven<br>
技术关键词：Spring Boot,Spring MVC,Spring Data,Spring Security,Hibernate,EhCache
# WebDemoDomain
主模块，包含通用实体层、数据持久化层、service层、其他通用类等
子模块运行前，WebDemoDomain模块需先执行mvn install命令
# WebDemoManagement子模块
后台管理Web模块
# WebDemoPortal子模块
前台用户Web模块
# 开发环境搭建流程
1.下载源码包并解压<br>
2.将三个工程导入到MyEclipse，导入方式：MyEclipse>import>existing maven projects<br>
3.在WebDemoDomain工程上右键，run as>maven install<br>
4.在WebDemoManagement工厂上右键，maven>update project>ok<br>
5.运行工程下Application.java<br>
PS:配置文件统一在application.properties文件中，根据本地环境自行修改

