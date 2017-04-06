package com.woowahan.wiccan.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@ComponentScan(basePackages = {"com.woowahan.wiccan.commons"})
@EnableJpaRepositories(basePackages = {"com.woowahan.wiccan.commons.repository"})
@EntityScan(basePackages = {"com.woowahan.wiccan.commons.entity"})
@Configuration
public class CommonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
