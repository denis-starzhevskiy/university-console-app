package com.university.universitytesttask.config;

import com.university.universitytesttask.helpers.ShellHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringShellConfig {


    @Bean
    public ShellHelper shellHelper() {
        return new ShellHelper();
    }

}
