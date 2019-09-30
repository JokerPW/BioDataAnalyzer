package br.com.gplab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.gplab.analysis.DataHolder;

@Configuration
public class AppConfig {
    
    @Bean
    public DataHolder dataHolder() {
        return new DataHolder();
    }
    
}