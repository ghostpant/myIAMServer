package my.ibm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("my.ibm.dao.mapper")
public class MyIBMServerApplication {

    public static void main(String[] args){
        SpringApplication.run(MyIBMServerApplication.class, args);
    }
}
