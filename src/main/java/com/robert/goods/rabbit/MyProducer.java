package com.robert.goods.rabbit;

import com.robert.goods.config.RabbitConfig;
import com.robert.goods.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 生产者
 * @author robert
 * @date 2021/4/15 11:51
 */

@Component
public class MyProducer implements RabbitTemplate.ConfirmCallback {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MyProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    /**
     * 只需要指定队列即可
     * @param content
     */
    public void sendMsg(String content) {
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitConfig.GOODS_QUEUE, content);
    }

    /**
     * 指定交换机，队列，id
     * @param content
     */
    public void sendMsgB(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_B, RabbitConfig.QUEUE_A, content, correlationId);
    }

    /**
     * Direct模式
     * 发送消息时只需要指定Queue队列名称，和消息
     */
    public void sendDirect(Object message) {

        String msg = JsonUtil.beanToStr(message);
        logger.info("send direct message:"+msg);
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_A, msg);
    }

    /**
     * Topic模式
     * 发送消息时需要指定交换器Exchange，routingKey，和消息
     */
    public void sendTopic(Object message) {

        String msg = JsonUtil.beanToStr(message);

        logger.info("send topic message:"+msg);

        //匹配得上routingKey=topic.key2
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "topic.key2", msg+"1");
        //使用通配符=topic.#
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "topic.key2", msg+"2");
    }

     /**
     * Fanout模式
     * 发送消息时需要指定交换器Exchange，空的routingKey，消息
     */
    public void sendFanout(Object message) {

        String msg = JsonUtil.beanToStr(message);

        logger.info("send fanout message:"+msg);

        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE, "", msg+"1");
    }

     /**
     * Headers模式
     * 发送消息时需要指定交换器Exchange，空的routingKey，Message对象
     */
    public void sendHeaders(Object message) {

        String msg = JsonUtil.beanToStr(message);

        logger.info("send headers message:"+msg);

        MessageProperties messageProperties = new MessageProperties();
        //必须与MQConfig中指定的map的key-value一样
        messageProperties.setHeader("header1", "value1");
        messageProperties.setHeader("header2", "value2");
        Message obj = new Message(msg.getBytes(), messageProperties);
        rabbitTemplate.convertAndSend(RabbitConfig.HEADERS_EXCHANGE, "", obj);
    }


    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info(" 回调id:" + correlationData);
        if (ack) {
            logger.info("消息成功消费");
        } else {
            logger.info("消息消费失败:" + cause);
        }
    }
}
