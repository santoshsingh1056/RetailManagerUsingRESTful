package appStart;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import database.ShopList;
import services.ShopLocatorService;

@SpringBootApplication(scanBasePackages = "controllers")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("You started!!!!!!!");
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ShopList shopList() {
        return new ShopList();
    }

    @Bean
    public ShopLocatorService shopLocatorService() {
        return new ShopLocatorService();
    }

}
