package com.woowahan.wiccan.management;

import com.woowahan.wiccan.commons.CommonConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@ComponentScan(basePackages = {"com.woowahan.wiccan"})
@EnableJpaRepositories(basePackages = {"com.woowahan.wiccan.management.repository"})
@EntityScan(basePackages = {"com.woowahan.wiccan.management.entity"})
@Import({CommonConfig.class})
@Configuration
public class ManagementConfig {
}
