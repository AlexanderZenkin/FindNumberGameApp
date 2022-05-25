package ru.lupapupa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.lupapupa.baseclass.BaseClass;

@Configuration
public class AppConfig {

    @Bean
    public BaseClass baseClass() {
        return new BaseClass();
    }
}
