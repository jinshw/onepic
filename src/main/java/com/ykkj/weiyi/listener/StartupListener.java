package com.ykkj.weiyi.listener;

import org.apache.log4j.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 *  项目启动后执行
 *  输出如下：
 * 1 => StartupListener.setApplicationContext
 * 2 => StartupListener.setServletContext
 * 3 => StartupListener.afterPropertiesSet
 * 4.1 => MyApplicationListener.onApplicationEvent
 * 4.2 => MyApplicationListener.onApplicationEvent
 * 4.1 => MyApplicationListener.onApplicationEvent
 *
 * 注意：onApplicationEvent方法会触发多次，初始化这种事情，越早越好，建议在setApplicationContext方法中处理。
 */
@Component
public class StartupListener implements ApplicationContextAware, ServletContextAware,
        InitializingBean, ApplicationListener<ContextRefreshedEvent> {

    protected Logger logger = LogManager.getLogger(StartupListener.class);

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        logger.info("1 => StartupListener.setApplicationContext");
    }

    @Override
    public void setServletContext(ServletContext context) {
        logger.info("2 => StartupListener.setServletContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("3 => StartupListener.afterPropertiesSet");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {
        logger.info("4.1 => MyApplicationListener.onApplicationEvent");
        if (evt.getApplicationContext().getParent() == null) {
            logger.info("4.2 => MyApplicationListener.onApplicationEvent");
        }
    }

}