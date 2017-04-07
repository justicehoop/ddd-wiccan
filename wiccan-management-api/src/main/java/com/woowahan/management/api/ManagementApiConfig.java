package com.woowahan.management.api;

import com.woowahan.wiccan.management.ManagementConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@Import({ManagementConfig.class})
@Configuration
public class ManagementApiConfig {
}
