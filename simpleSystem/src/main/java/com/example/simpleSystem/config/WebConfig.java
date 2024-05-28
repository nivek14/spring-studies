package com.example.simpleSystem.config;

import com.example.simpleSystem.serializationconverter.YamlJacksonToHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.simpleSystem.util.MediaType;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(new YamlJacksonToHttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        /* config via query param
        configurer.favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);*/

        //config via header param
        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(org.springframework.http.MediaType.valueOf(MediaType.APPLICATION_JSON))
                .mediaType("json", org.springframework.http.MediaType.valueOf(MediaType.APPLICATION_JSON))
                .mediaType("xml", org.springframework.http.MediaType.valueOf(MediaType.APPLICATION_XML))
                .mediaType("x-yml", org.springframework.http.MediaType.valueOf(MediaType.APPLICATION_YML));

    }

}
