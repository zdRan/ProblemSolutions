# Feign 的简单使用
## 1. 简介
Feign 是简化Java HTTP客户端开发的工具。它使用注解的方式将HTTP的URL封装成接口，每个URL对应一个接口，大大简化了HTTP客户端的开发。


## 1. 添加依赖
```
<dependency>
    <groupId>io.github.openfeign</groupId>
    <artifactId>feign-core</artifactId>
</dependency>
<dependency>
    <groupId>io.github.openfeign</groupId>
    <artifactId>feign-jackson</artifactId>
</dependency>
<dependency>
    <groupId>io.github.openfeign</groupId>
    <artifactId>feign-httpclient</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
</dependency>
```
## 2. 接口类
这里主要介绍下接口的几种传参方式。
```

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Create by *** on 2018/3/20
 *
 */
//Headers 注解：配置请求头信息
@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface UserApi {
    /**
     * RequestLine 注解：请求的方法与url，这里需要注意的是url写的是与Controller里的地址，不是完整的url地址。
     * GET 请求方法，遵循RESTful风格
     * @return
     */
    @RequestLine("GET /user/all")
    List<User> getAllUser();

    /**
     * restful方式传参
     * @param name
     * @return
     */
    @RequestLine("GET /user/{name}")
    User getByName(@Param("name") String name);

    /**
     * url方式传参数
     * @param id
     * @return
     */
    @RequestLine("GET /user/id?id={id}")
    User getById(@Param("id") String id);

    /**
     * post 传参，传复杂类型
     * @param user
     */
    @RequestLine("POST /user/add")
    void addUser(User user);
}

```

## 3. 该类对应的请求Controller
```
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by *** on 2018/3/20
 *
 */
@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    @GetMapping(value = "/all")
    List<User> getAll(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("获取所有用户");
        users.add(user);
        return users;
    }
    @GetMapping(value = "/{name}")
    User getByName(@PathVariable String name){
        User user = new User();
        user.setName("获取用户："+name);
        return user;
    }
    @GetMapping(value = "/id")
    User getById(String id){
        User user = new User();
        user.setName("获取用户："+id);
        return user;
    }
    @PostMapping(value = "/add")
    void addUser(@RequestBody User user){

    }
}

```

## 4. 使用
```
import feign.Feign;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Create by *** on 2018/3/20
 *
 */
@Controller
public class ClientController {
    private static final String apiBaseUrl = "http://localhost:8080/feign";
    UserApi userApi = Feign.builder()
            .client(new ApacheHttpClient())
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(UserApi.class, apiBaseUrl);
    
    @GetMapping(value = "/client/user/{name}")
    public User getUserInfo(@PathVariable String name){
        return userApi.getByName(name);
    }

}

```