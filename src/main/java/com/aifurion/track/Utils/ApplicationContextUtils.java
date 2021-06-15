package com.aifurion.track.Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: zzy
 * @description: 获取bean工具类
 * @date: 2021/3/23 20:12
 * @Param: null
 */

@Component
public class ApplicationContextUtils implements ApplicationContextAware {


    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        context = applicationContext;

    }


    //更具bean的名字获取bean
    public static Object getBean(String beanName) {

        return context.getBean(beanName);

    }
}
