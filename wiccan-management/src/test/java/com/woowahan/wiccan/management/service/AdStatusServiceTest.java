package com.woowahan.wiccan.management.service;

import com.woowahan.wiccan.management.ManagementConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ManagementConfig.class})
@Slf4j
@Transactional
public class AdStatusServiceTest {

    @Autowired
    private AdStatusService adStatusService;

    @Test
    public void 광고상태가_정상적으로_변경되어야_한다() {

    }

}