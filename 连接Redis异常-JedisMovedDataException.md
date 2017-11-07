# 连接Redis异常：JedisMovedDataException
## 环境
java API连接redis 
出现下面的异常信息：

```
redis.clients.jedis.exceptions.JedisMovedDataException: MOVED 1539 172.31.59.103:6379
```
## 解决方案

将连接对象从 Jedis 换成 JedisCluster。就可以了。

## 问题原因

MOVED表示使用的是Redis群集。而 Jedis 不是集群模式。

## code
```
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.JedisCluster;

HostAndPort hostAndPort = new HostAndPort(host, port);
Set<HostAndPort> hostAndPortSet = new HashSet<>();
hostAndPortSet.add(hostAndPort);
JedisCluster jedis = new JedisCluster(hostAndPortSet);
jedis.setnx(key, value);

```