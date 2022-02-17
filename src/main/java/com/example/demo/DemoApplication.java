package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication(exclude={
        DataSourceAutoConfiguration.class,
        //        HibernateJpaAutoConfiguration.class, //（如果使用Hibernate时，需要加）  
        DataSourceTransactionManagerAutoConfiguration.class
})
@EnableJms //启动消息队列
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
