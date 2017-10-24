# spring 声明式事物
## 配置

在 ```spring-mybatis.xml```中配置如下代码：

```
<tx:annotation-driven />
```
## 使用
在需要回滚的方法上添加```@Transactional```注解

## 使用时的问题

### 1.注解必须添加到接口方法上
```
public interface UserService {
	int fun();
}

public class UserServiceImpl implements UserService{

	@Autowired
	IUserDao userDao;

	@Transactional
	public int fun1(){
		throw new RuntimeException();
		return 0;
	}
	
	public int fun(){
		return fun1());
	}
}

```

以上代码事物不会回滚，因为```fun1()```方法不是接口内的方法。

需要将```@Transactional```注解放在```fun()```上，事物才会生效。

### 2. rollbackFor 与 noRollbackFor

默认配置时，spring事务中抛出的异常是RuntimeException或者是其子类，这样事务才会回滚（默认情况下Error也会导致事务回滚）。

也可以通过配置```rollbackFor={xxx.class,xxx.class}```,指定哪些异常需要回滚。

```noRollbackFor={xxx.class,xxx.class}```参数是用来指定哪些异常不需要回滚的。

### 3. 一些有趣的小测试

rollbackFor 父类，throw 子类，事物回滚

```

public class UserServiceImpl implements UserService{

	@Autowired
	IUserDao userDao;

	@Transactional(rollbackFor={RuntimeException.class})
	public int fun(){
		throw new NullPointerException();
		return 0;
	}
}
```

自定义异常：继承自Exception,事物回滚

```
public class TestException extends Exception{

}

public class TestsubException extends TestException{

}
public class UserServiceImpl implements UserService{

	@Autowired
	IUserDao userDao;

	@Transactional(rollbackFor={TestException.class})
	public int fun() throws TestsubException{
		throw new TestsubException();
		return 0;
	}
}

```

noRollbackFor 与 rollbackFor 类似，配置父类，抛出子类的话，配置生效不会回滚。

### 4.有趣的来了，rollbackFor与noRollbackFor同时配置的情况

精确匹配原则，下面的代码不会回滚

```
public class UserServiceImpl implements UserService{

	@Autowired
	IUserDao userDao;

	@Transactional(rollbackFor={RuntimeException.class}, noRollbackFor={NullPointerException.class})
	public int fun(){
		throw new NullPointerException();
		return 0;
	}
}
```
