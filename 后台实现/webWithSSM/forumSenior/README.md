# SSM从零开始搭建一个项目
##  一、新建项目

### 1. 通过maven创建webapp

### 2. 集成ssm

> [参考](https://www.cnblogs.com/zyw-205520/p/4771253.html )

#### 2.1 新建目录结构

java

- controller
- model
- service
   - impl
- dao

resources

- spring-mvc.xml
- spring-mybatis
- jdbc.proterties
- log4j.properties

#### 2.2 pom.xml

```java
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.dongda.forum</groupId>
  <artifactId>forum</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>forum Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>

    <!-- spring版本号 -->
    <spring.version>4.0.2.RELEASE</spring.version>
    <!-- mybatis版本号 -->
    <mybatis.version>3.2.6</mybatis.version>
    <!-- log4j日志文件管理包版本 -->
    <slf4j.version>1.7.7</slf4j.version>
    <log4j.version>1.2.17</log4j.version>

    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
    <!-- junit -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <!-- 表示开发的时候引入，发布的时候不会加载此包 -->
      <scope>test</scope>
    </dependency>

    <!-- spring核心包 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-oxm</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context-support</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <!-- mybatis核心包 -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${mybatis.version}</version>
    </dependency>
    <!-- mybatis/spring包 -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.2.2</version>
    </dependency>

    <!-- 导入java ee jar 包 -->
    <dependency>
      <groupId>javax</groupId>
      <artifactId>javaee-api</artifactId>
      <version>7.0</version>
    </dependency>

    <!-- 导入Mysql数据库链接jar包 -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.36</version>
    </dependency>
    <!-- 导入dbcp的jar包，用来在applicationContext.xml中配置数据库 -->
    <dependency>
      <groupId>commons-dbcp</groupId>
      <artifactId>commons-dbcp</artifactId>
      <version>1.2.2</version>
    </dependency>

    <!-- JSTL标签类 -->
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <!-- 日志文件管理包 -->
    <!-- log start -->
    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>${log4j.version}</version>
    </dependency>


    <!-- 格式化对象，方便输出日志 -->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.1.41</version>
    </dependency>


    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>${slf4j.version}</version>
    </dependency>

    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>${slf4j.version}</version>
    </dependency>
    <!-- log end -->
    <!-- 映入JSON -->
    <dependency>
      <groupId>org.codehaus.jackson</groupId>
      <artifactId>jackson-mapper-asl</artifactId>
      <version>1.9.13</version>
    </dependency>
    <!-- 上传组件包 -->
    <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.3.1</version>
    </dependency>
    <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.4</version>
    </dependency>
    <dependency>
      <groupId>commons-codec</groupId>
      <artifactId>commons-codec</artifactId>
      <version>1.9</version>
    </dependency>

  </dependencies>

  <build>
    <finalName>forum</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>

```

#### 2.3 整合 spring-mvc

##### 2.3.1 spring-mvc.xml

主要是**自动扫描控制器**，**视图模式**，**注解的启动** 。

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context-3.1.xsd
                        http://www.springframework.org/schema/mvc
                        http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd">
    <!-- 自动扫描该包，使SpringMVC认为包下用了@controller注解的类是控制器 -->
    <context:component-scan base-package="com.sun.controller" />
    <!-- 扩充了注解驱动，可以将请求参数绑定到控制器参数 -->
    <mvc:annotation-driven/>
    <!-- 静态资源处理  css js imgs -->
    <mvc:resources location="/resources/**" mapping="/resources"/>

    <!--避免IE执行AJAX时，返回JSON出现下载文件 -->
    <bean id="mappingJacksonHttpMessageConverter"
          class="org.springframework.http.converter.json.MappingJacksonHttpMessageConverter">
        <property name="supportedMediaTypes">
            <list>
                <value>text/html;charset=UTF-8</value>
            </list>
        </property>
    </bean>
    <!-- 启动SpringMVC的注解功能，完成请求和注解POJO的映射 -->
    <!--<bean
            class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
        <property name="messageConverters">
            <list>
                <ref bean="mappingJacksonHttpMessageConverter" /> &lt;!&ndash; JSON转换器 &ndash;&gt;
            </list>
        </property>
    </bean>-->

    <!-- 配置文件上传，如果没有使用文件上传可以不用配置，当然如果不配，那么配置文件中也不必引入上传组件包 -->
    <!--<bean id="multipartResolver"
          class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        &lt;!&ndash; 默认编码 &ndash;&gt;
        <property name="defaultEncoding" value="utf-8" />
        &lt;!&ndash; 文件大小最大值 &ndash;&gt;
        <property name="maxUploadSize" value="10485760000" />
        &lt;!&ndash; 内存中的最大值 &ndash;&gt;
        <property name="maxInMemorySize" value="40960" />
        &lt;!&ndash; 启用是为了推迟文件解析，以便捕获文件大小异常 &ndash;&gt;
        <property name="resolveLazily" value="true"/>
    </bean>-->

    <!-- 配置ViewResolver 。可用多个ViewResolver 。使用order属性排序。   InternalResourceViewResolver 放在最后-->
    <bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
        <property name="order" value="1"></property>
        <property name="mediaTypes">
            <map>
                <!-- 告诉视图解析器，返回的类型为json格式 -->
                <entry key="json" value="application/json" />
                <entry key="xml" value="application/xml" />
                <entry key="htm" value="text/htm" />
            </map>
        </property>
        <property name="defaultViews">
            <list>
                <!-- ModelAndView里的数据变成JSON -->
                <bean class="org.springframework.web.servlet.view.json.MappingJacksonJsonView" />
            </list>
        </property>
        <property name="ignoreAcceptHeader" value="true"></property>
    </bean>

    <!-- 定义跳转的文件的前后缀 ，视图模式配置-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- 这里的配置我的理解是自动给后面action的方法return的字符串加上前缀和后缀，变成一个 可用的url地址 -->
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>
</beans>
```

##### 2.3.2 web.xml

```java
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>Archetype Created Web Application</display-name>
  <!-- Spring和mybatis的配置文件 -->
  <!--  <context-param>
       <param-name>contextConfigLocation</param-name>
       <param-value>classpath:spring-mybatis.xml</param-value>
   </context-param>   -->
  <!-- 编码过滤器 -->
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
  <!-- Spring监听器 -->
  <!--  <listener>
       <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
   </listener>   -->
  <!-- 防止Spring内存溢出监听器 -->
  <!-- <listener>
      <listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
  </listener>  -->

  <!-- Spring MVC servlet -->
  <servlet>
    <servlet-name>SpringMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>SpringMVC</servlet-name>
    <!-- 此处可以可以配置成*.do，对应struts的后缀习惯 -->
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  <welcome-file-list>
    <welcome-file>/index.jsp</welcome-file>
  </welcome-file-list>
</web-app>

```

##### 2.3.2 controller

UserController

```java
package com.sun.controller;

// slf4j.Logger
import com.sun.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
// /user/**
public class UserController {
    private static Logger log= LoggerFactory.getLogger(UserController.class);


    // /user/test?id=1
    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("userId:"+userId);
        User user=null;
        if (userId==1) {
            user = new User();
            user.setAge(11);
            user.setId(1);
            user.setPassword("123");
            user.setUserName("javen");
        }

        log.debug(user.toString());
        model.addAttribute("user", user);
        return "index";
    }
}
```

##### 2.3.3 model

User

```java
package com.sun.model;

public class User {
    private Integer id;

    private String userName;

    private String password;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password="
                + password + ", age=" + age + "]";
    }
}

```

##### 2.3.4 jsp

在WEB-INF目录下新建jsp目录，在jsp目录下新建index.jsp

index.jsp

```java
<!-- 不加这句话，${user.id}无法解析-->
<%@ page isELIgnored="false"%>
<html>
<body>
<%= request.getAttribute("user") %>
<h2>Hello World!,${user.id}</h2>
</body>
</html>
```

##### 2.3.5 测试

> 浏览器中输入：http://localhost:8080/user/test?id=1

#### 2.4 在SpingMVC的基础上整合MyBatis

##### 2.4.1 jdbc.properties

jdbc.properties

```
driver=com.mysql.jdbc.Driver
#ssm为数据库名
url=jdbc:mysql://localhost:3306/ssm
#连接用户名
username=root
#连接密码
password=root
#定义初始连接数  
initialSize=0  
#定义最大连接数  
maxActive=20  
#定义最大空闲  
maxIdle=20  
#定义最小空闲  
minIdle=1  
#定义最长等待时间  
maxWait=60000  

```

##### 2.4.2 自动生成mapper、dao、entity


自动生成dao、entity、mapper


> [小螺号滴滴吹](https://gitee.com/rohou)

1. 修改pom.xml

```xml
<!--增加plugin-->
<plugin>
          <groupId>org.mybatis.generator</groupId>
          <artifactId>mybatis-generator-maven-plugin</artifactId>
          <version>1.3.2</version>
          <configuration>
            <configurationFile>${basedir}/src/main/resources/generator/generatorConfig.xml</configurationFile>
            <overwrite>true</overwrite>
            <verbose>true</verbose>
          </configuration>
</plugin>
```

2. generatorConfiguration.xml

​        resources下创建generator->generatorConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!-- 数据库驱动:选择你的本地硬盘上面的数据库驱动包-->
    <classPathEntry location="D:\web\mysql-connector-java-5.1.25-bin.jar"/>
    <context id="DB2Tables" targetRuntime="MyBatis3">
        <commentGenerator>
            <property name="suppressDate" value="true"/>
            <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
            <property name="suppressAllComments" value="true"/>
        </commentGenerator>
        <!--数据库链接URL,ssm为数据库名，用户名、密码 -->
        <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1:3306/ssm" userId="root" password="">
        </jdbcConnection>
        <javaTypeResolver>
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>
        <!-- 生成模型的包名和位置-->
        <javaModelGenerator targetPackage="com.sun.model" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>
        <!-- 生成映射文件的包名和位置-->
        <sqlMapGenerator targetPackage="mapping" targetProject="src/main/resources">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>
        <!-- 生成DAO的包名和位置-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.sun.dao" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>
        <!-- 要生成的表 tableName是数据库中的表名或视图名 domainObjectName是实体类名-->
        <table tableName="t_user_test" domainObjectName="User" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>
    </context>
</generatorConfiguration>
```

3. idea安装插件

   file->settings->plugins安装插件

4. 创建表

```
CREATE TABLE `user` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT,
	`user_name` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	`phone` varchar(255) NOT NULL,
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8
```

5. 配置启动文件

   ​	edit Configurations

   ​	```Command line:mybatis-generator:generate -e```

6. 运行generator

7. 结果&问题总结

```
发现生成的实体类和mapper文件中，字段有多余的空格。
eg：
<if test="  userName != null" >
#{  userName,jdbcType=VARCHAR}
问题排查：
数据库建表字段中有空格
解决办法：
去除多余空格，修改后成功。   
```



### 二、 进阶
#### 2.1 mybatis拦截器实现分页

> [参考](https://blog.csdn.net/huyiju/article/details/82454735 )
>
> [参考](https://blog.csdn.net/abcd898989/article/details/51261163 )

使用拦截器拦截原始的sql，然后加上分页查询的关键字和属性，拼装成新的sql语句再交给mybatis去执行。 

### 三、问题总结

1. controller与jsp互相传值

> [SpringMVC的controller向jsp传递数据的五种方式详解](https://blog.csdn.net/qq_40646143/article/details/79536909 )

2. jsp不解析{user.id}

```
<!-- 不加这句话，${user.id}无法解析-->
<%@ page isELIgnored="false"%>
```

3. 不允许有匹配 "[xX][mM][lL]" 的处理指令目标。

```
在使用mybatis-generator时报错
解决方法：
generatorConfiguration.xml的配置文件中第一行有空行，去掉后就可以了。
```

4. classpath:代表的位置

```xml
<!-- 引入配置文件 classpath代表了target的classes路径 -->
<!-- 路径配置成功后不会报红，按住ctrl，鼠标左键可以定位到相关配置文件 -->
<bean id="propertyConfigurer"
          class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="location" value="classpath:jdbc.properties" />
</bean>
```
3. 注解AutoWired&Resource区别