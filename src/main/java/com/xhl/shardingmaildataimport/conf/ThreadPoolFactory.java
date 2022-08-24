package com.xhl.shardingmaildataimport.conf;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolFactory {

    @Autowired
    private ThreadPoolConf threadPoolConf;

    @Bean(name = "threadPoolExecutor")
    public ThreadPoolExecutor getThreadPool() {
        // 给线程指定名称，方便查看线程编号
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("conf-thread-pool-%d").build();

        // 创建线程池
        return new ThreadPoolExecutor(threadPoolConf.getCorePoolSize(),
                threadPoolConf.getMaximumPoolSize(),
                threadPoolConf.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(threadPoolConf.getQueueCapacity()),
                namedThreadFactory);
    }
}