package com.woowahan.wiccan.impression;

import com.woowahan.wiccan.commons.CommonConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@Import({CommonConfig.class})
@ComponentScan(basePackages = {"com.woowahan.wiccan"})
@EnableJpaRepositories(basePackages = {"com.woowahan.wiccan"})
@EntityScan(basePackages = {"com.woowahan.wiccan"})
@Configuration
public class AdImpressionConifig {
}
