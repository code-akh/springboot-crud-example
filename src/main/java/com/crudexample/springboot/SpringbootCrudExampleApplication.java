package com.crudexample.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCrudExampleApplication {

    public static void main(String args[]) {
        SpringApplication.run(SpringbootCrudExampleApplication.class);
    }

/*    public static void main(String[] args) {
        PropertiesUtil.initProperties();

        ConfigurableApplicationContext context = SpringApplication.run(SpringbootCrudExampleApplication.class, args);
        SpringbootCrudExampleApplication app = context.getBean(SpringbootCrudExampleApplication.class);

        printEnvironmentProperties(app);
    }*/
}
