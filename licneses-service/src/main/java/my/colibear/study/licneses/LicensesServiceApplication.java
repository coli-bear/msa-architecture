package my.colibear.study.licneses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class LicensesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicensesServiceApplication.class, args);
    }

}
