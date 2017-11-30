# Tomcat 启动报错
## 问题环境
同样的代码，在本地正常跑，发布到服务器tomcat就启动失败

错误日志
```
严重: Context [/dsfquery] startup failed due to previous errors

```
在容器日志里找到了下面的日志

```
 Exception sending context initialized event to listener instance of class org.springframework.web.context.ContextLoaderListener
org.springframework.beans.factory.CannotLoadBeanClassException: Error loading class [com.xxx.xxx.xxxx.xxx] for bean with name 'com.xxx.xxx.xxxx.xxx' defined in file [/.../.../WEB-INF/classes/META-INF/spring/init.xml]: problem with class file or dependent class; nested exception is java.lang.UnsupportedClassVersionError: com.xxx.xxx.xxxx.xxx : Unsupported major.minor version 52.0 (unable to load class com.xxx.xxx.xxxx.xxx)

```

解决方法：
一开始以为是打包失败了，漏掉了某些文件。检查了N遍发现不是打包的问题。

真正的问题原因是：本地的jdk与服务器上的jdk版本不一致！！！