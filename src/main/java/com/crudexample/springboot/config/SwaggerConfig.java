package com.crudexample.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements EnvironmentAware {

    @Autowired
    private Environment environment;

    @Bean
    public Docket postApi() {

        System.out.println("Printing Environment value - : " + environment.getProperty("use-swagger"));

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                .enable(Boolean.parseBoolean(environment.getProperty("use-swagger")))
                .select()
                .paths(PathSelectors.regex("/api/employees/*.*"))
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("Emp Service")
                .description("Api Reference for Developers")
                .termsOfServiceUrl("http://www.google.com")
                .license("Demo Licence")
                .licenseUrl("https://www.gmail.com")
                .version("1.0")
                .build();

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
