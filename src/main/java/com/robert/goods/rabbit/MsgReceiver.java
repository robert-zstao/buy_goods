package com.robert.goods.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

/**
 * @author robert
 * @date 2021/4/15 11:59
 *
 * 1个生产者，1个消费者
 */
//@Component
//@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content) {
        //处理逻辑
        logger.info("接收处理队列A当中的消息： " + content);
    }

}

