package com.robert.goods.rabbit;

import com.robert.goods.bean.User;
import com.robert.goods.config.RabbitConfig;
import com.robert.goods.service.IUserService;
import com.robert.goods.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author robert
 * @date 2021/4/15 11:59
 *
 * 1个生产者，1个消费者
 */
@Component
public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    /**
     * 第四步：请求出队，生产订单，减少库存   其它几步在MIaoshaController.class
     * 秒杀 Direct模式 交换机Exchange
     */
    @RabbitListener(queues = RabbitConfig.GOODS_QUEUE)
    public void receiver(String message) {
        logger.info("receiver direct message:"+message);
        GoodMessage goodMessage = JsonUtil.strToBean(message, GoodMessage.class);
        User user = goodMessage.getUser();
        int goodsId = goodMessage.getGoodsId();

        //判断库存
//        GoodsVo goodsVo = goodsService.selectGoodsVoByGoodsId(goodsId);
//        Integer stockCount = goodsVo.getStockCount();
//        if (stockCount <= 0) {
//            return;
//        }
//
//        //判断是否已经秒杀到了 防止重复购买(消息入队前，已经被判断了一次 MIaoshaController.class)
//        MiaoshaOrder miaoshaOrder = orderService.selectMiaoshaOrderByMiaoshaUserIdAndGoodsId(user.getId(), goodsId);
//        if (miaoshaOrder != null) {
//            return;
//        }
//
//        //减库存 下订单 写入秒杀订单（三步必须放入一个事务里提交）
//        miaoshaService.miaosha(user, goodsVo);
    }


    /**
     * Direct模式 交换机Exchange
     */
//    @RabbitListener(queues = RabbitConfig.QUEUE_A)
//    public void receiverA(String message) {
//        logger.info("receiver direct message:"+message);
//    }

    /**
     * Topic模式 交换机Exchange
     */
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public void receiverTopic1(String message) {
        logger.info("receiver topic queue1 message:"+message);
    }

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
    public void receiverTopic2(String message) {
        logger.info("receiver topic queue2 message:"+message);
    }
//
//    /**
//     * Headers模式 交换机Exchange
//     *  与其它的模式不同，接受的是字节数组
//     */
//    @RabbitListener(queues = RabbitConfig.HEADERS_QUEUE)
//    public void receiverHeaders(byte[] message) {
//        logger.info("receiver headers queue message:"+new String(message));
//    }

}

