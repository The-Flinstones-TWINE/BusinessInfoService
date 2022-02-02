package com.twine.businessinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@EnableSwagger2
@SpringBootApplication
public class BusinessInfoServiceApplication {
//    @Bean
//    public Docket docket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.twine.businessinfoservice"))
//                .build();
//    }

    public static void main(String[] args) {
        SpringApplication.run(BusinessInfoServiceApplication.class, args);
    }

}
