package com.exampleyuri.demo;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    public static final Contact DEFAULT_CONTACT = new Contact("Yuri Carranza", "http://yuricarranza.com", "yuricarranzaq@gmail.com");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api reto tech", "Definición de la API del reto tech", "1.0", "",
            DEFAULT_CONTACT, "", "", new ArrayList<VendorExtension>());
    

	@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(DEFAULT_API_INFO)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.exampleyuri.demo"))
                .paths(PathSelectors.any())
                .build();
    }
    
}