package top.xinsin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("top.xinsin.dao")
@SpringBootApplication
public class SpringBootApplicationLaunch {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationLaunch.class, args);
    }
}