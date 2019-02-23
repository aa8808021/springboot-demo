package com.mytest.mgInitialization;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SystemInitializer implements ApplicationListener<ContextRefreshedEvent> {

    //初始化数据
    @Bean
    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        if (true) {//文件没有被加载
            //加载.json文件
            Resource initData = new ClassPathResource("init/initTestData.json");
            factory.setResources(new Resource[]{initData});
        } else {
            factory.setResources(new Resource[]{});
        }

        return factory;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        log.info("监听springboot启动成功");
    }

}
