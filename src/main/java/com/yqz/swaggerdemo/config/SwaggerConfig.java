package com.yqz.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.prefs.AbstractPreferences;

@Configuration
@EnableOpenApi //开启swagger
public class SwaggerConfig {
//  配置bean示例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                /*
                * basePackage("com.yqz.Swagger.controller"))  扫描包
                * any()
                * none()
                * withClassAnnotation 扫描类上的注解，参数是一个注解的反射对象
                * withMethodAnnotation 扫描方法上的注解
                * */
                .apis(RequestHandlerSelectors.basePackage("com.yqz.swaggerdemo.controller"))
//               .path()过滤什么路径
                .paths(PathSelectors.ant("/yqz/*"))
                .build();
    }
    private ApiInfo apiInfo(){
        Contact contact = new Contact("yqz", "localhost", "chenhc1997@gmail.com");
        return new ApiInfo("YQZ的swagger",
                "u can u up",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
