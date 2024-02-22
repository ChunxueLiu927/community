package com.test.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @ClassName AlphaConfig
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/21 16:35
 * @Version 1.0
 */
@Configuration
public class AlphaConfig {

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
    }

}
