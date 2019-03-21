package com.yxw.web.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author:阿倪
 * @Date: 2019/3/6 16:22
 * @Description:
 * @return:
 * @throws:
 */
@Configuration
public class DefaultController extends WebMvcConfigurerAdapter {

    /**
     * 默认访问首页controller
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
