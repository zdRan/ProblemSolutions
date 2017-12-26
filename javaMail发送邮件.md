# javaMail 发送邮件带附件
## 环境

+ javaMail
+ qq邮箱授权

## qq邮箱授权

在qq邮箱里的 设置-> 账户 下面

开启 POP3/SMTP、IMAP/SMTP 服务，开启后会显示一个授权码，这个就是登陆邮箱的密码

## 添加pom依赖

```
        <!-- https://mvnrepository.com/artifact/javax.mail/mail -->
        <dependency>
            <groupId>javax.mail</groupId>
            <artifactId>mail</artifactId>
            <version>1.4</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.sun.mail/javax.mail -->
        <dependency>
            <groupId>com.sun.mail</groupId>
            <artifactId>javax.mail</artifactId>
            <version>1.5.4</version>
        </dependency>
```

## 导入email目录下的四个类

不必导入 *Test.java 的文件

## 测试代码
```
public class MultiMailSenderTest {
    @Test
    public void sendAnnexMail() throws Exception {
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.qq.com");
        mailInfo.setMailServerPort("465");
        mailInfo.setValidate(true);
        mailInfo.setUserName("111111@qq.com");
        mailInfo.setPassword("*****************");//授权码
        mailInfo.setFromAddress("111111@qq.com");//必须跟userName一致
        mailInfo.setSubmitTo("xxx@xxx.xxx,xxx@xxx.xxx");
        mailInfo.setCarbonCopy("xxx@xxx.xxx,xxx@xxx.xxx");
        mailInfo.setSubject("这是一份测试附件发送的邮件");
        mailInfo.setContent("测试邮件附件发送是否成功，来自qq邮箱");
        String[] path = new String[]{"D:\\xxx\\xxx.txt","D:\\xxx\\xxx.txt"};
        mailInfo.setAttachFileNames(path);

        MultiMailSender sender = new MultiMailSender();
        sender.sendAnnexMail(mailInfo);
    }
}
```

## 源码地址

[Github](https://github.com/zdRan/ProblemSolutions/tree/master/email)