# buy_goods
### 项目介绍

* 这是一个基于java的秒杀系统

#### 技术选型

* SpringBoot
* MyBatis
* MySQL
* Redis
* kafka 和RabbitMQ两个版本
* Template
* maven



### 操作流程

* 缓存
  * 项目启动时将商品库存缓存redis
  * 也可以使用定时器提前一段时间进行缓存

* 登录
  * 账号密码登录
  * 用户信息缓存redis
* 查看商品信息
* 抢购
* 验证
* 订单
* 支付