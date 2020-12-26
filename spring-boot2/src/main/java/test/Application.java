package test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description: 启动类
 * @author: gb
 * @create: 2020/09/25
 */
@SpringBootApplication
@MapperScan("test.case1.domain")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
