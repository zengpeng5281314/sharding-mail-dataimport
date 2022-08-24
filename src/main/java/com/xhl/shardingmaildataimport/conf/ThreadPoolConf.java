package com.xhl.shardingmaildataimport.conf;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
/**
 *
 线程池配置参数
 */
public class ThreadPoolConf {

    /**
     * 核心线程数的最大值
     */
    @Value("${thread-pool.corePoolSize}")
    private Integer corePoolSize;

    /**
     * 线程池中能拥有最多线程数
     */
    @Value("${thread-pool.maximumPoolSize}")
    private Integer maximumPoolSize;

    /**
     * 非核心线程空闲存在时间(单位:秒)
     */
    @Value("${thread-pool.keepAliveTime}")
    private Integer keepAliveTime;

    /**
     * 线程池等待队列最大容量
     */
    @Value("${thread-pool.queueCapacity}")
    private Integer queueCapacity;
}
