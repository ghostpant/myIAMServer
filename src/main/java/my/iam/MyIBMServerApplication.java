package my.iam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("my.iam.dao.mapper")
public class MyIBMServerApplication {

    public static void main(String[] args){
        SpringApplication.run(MyIBMServerApplication.class, args);
    }
}
