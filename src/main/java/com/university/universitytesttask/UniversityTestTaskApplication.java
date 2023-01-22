package com.university.universitytesttask;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

@SpringBootApplication
public class UniversityTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityTestTaskApplication.class, args);
    }

    @Bean
    public PromptProvider CustomPromtProvider(){
        return () -> new AttributedString("UNIVERSITY-TEST_TASK:>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
    }

}
