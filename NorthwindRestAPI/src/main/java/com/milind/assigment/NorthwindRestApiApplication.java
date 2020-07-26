package com.milind.assigment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class NorthwindRestApiApplication {

	static Logger logger = LoggerFactory.getLogger(NorthwindRestApiApplication.class);
	
	public static void main(String[] args) {
		logger.info("Application Initialised!!");
		SpringApplication.run(NorthwindRestApiApplication.class, args);
	}
	
	@Bean
    public Docket api() {
		logger.info("Definong docket for swagger 2");
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.milind.assigment.controllers"))              
          .paths(PathSelectors.any())                          
          .build().pathMapping("/");                                           
    }

}
