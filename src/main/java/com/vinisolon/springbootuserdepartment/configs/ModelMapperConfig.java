package com.vinisolon.springbootuserdepartment.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapperInstance() {
        return new ModelMapper();
    }
}
