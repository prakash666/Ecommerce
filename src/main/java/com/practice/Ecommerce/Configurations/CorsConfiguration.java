package com.practice.Ecommerce.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration{

    private static final String POST = "POST";
    private static final String GET = "GET";
    private static final String DELETE = "DELETE";
    private static final String PUT = "PUT";
    private static final String PATCH = "PATCH";



    public WebMvcConfigurer corsConfigurer(){  // WebMvcConfigurer = This is the interface provied by Spring mvc that allows you to customize and configure different aspects oof spring MVC framwork
        return new WebMvcConfigurer() { //The corsConfigurer method is intended to return an instance of WebMvcConfigurer that provides custom configurations. Since WebMvcConfigurer is an interface, you can't directly create an instance of it. Instead, you need to provide an implementation by using an anonymous inner class.
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")                              // this means CORS configuration should apply to all the URL paths
                        .allowedMethods(POST,PUT,PATCH,DELETE,GET)              // this means this HTTP methods are allowed for CROS origin
                        .allowedHeaders("*")                                    // allows any headers to be included in the cross-origin requst. * means all
                        .allowedOrigins("*")                                    // This means my application will accept cross-origin request from any website
                        .allowCredentials(true);                                // this means browser can include any credentials
            }
        };
    }




}
