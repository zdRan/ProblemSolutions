# spring boot 下多环境配置占位符无法使用
## 环境
+ spring boot
+ mavne
+ 多环境配置占位符

之前做多环境配置的时候都是在 pom.xml 文件里写好标签，然后在 properties 使用```${key}```引用，打包之后就会自动替换掉。
但是在使用 spring boot 后发现，居然替换不了。


## 解决方案
将 properties 里的 ```${key}``` 替换成 ```@key@```。

## 问题原因 
maven 继承了 spring-boot-starter-parent，并且 spring 的占位符也是 ```${key}```, 导致 mavenfilter 的占位符被 spring 的 maven pom 替换掉了，变成了 ```@key@ ```，我们可以通过resource.delimiter来覆盖它。
