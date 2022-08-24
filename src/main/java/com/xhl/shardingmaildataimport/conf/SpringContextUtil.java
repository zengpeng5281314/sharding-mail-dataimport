package com.xhl.shardingmaildataimport.conf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("SpringContextUtil")
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 通过name获取 Bean
     * @param name beanName
     * @return Object
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }



    public static <T> T getBean(Class<T> requiredType) throws BeansException{
        return getApplicationContext().getBean(requiredType);
    }
}
