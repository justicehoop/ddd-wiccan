package com.woowahan.wiccan.management.service;

import com.woowahan.wiccan.management.ManagementConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ManagementConfig.class})
@Slf4j
public abstract class ManagementTestBase {
}
