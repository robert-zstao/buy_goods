package com.robert.goods.service.impl;

import com.robert.goods.service.IAsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author robert
 * @date 2021/5/19 9:53
 */
@Service
public class AsyncService implements IAsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    /**
     * 将Service层的服务异步化，在executeAsync()方法上增加注解@Async("asyncServiceExecutor")，
     * asyncServiceExecutor方法是前面ExecutorConfig.java中的方法名，
     * 表明executeAsync方法进入的线程池是asyncServiceExecutor方法创建的。
     */
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        logger.info("start executeAsync");
        System.out.println("异步线程要做的事情");
        System.out.println("可以在这里执行批量插入等耗时的事情");
        logger.info("end executeAsync");
    }
}
