package com.woowahan.wiccan.commons.event.sourcing;

import com.woowahan.wiccan.commons.CommonConfig;
import com.woowahan.wiccan.commons.entity.DomainEventHistory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
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
@SpringBootTest(classes = {CommonConfig.class})
@Slf4j
@Transactional
public class DomainEventStoreTest {

    @Autowired
    private DomainEventStore<String> eventStore;

    @Test
    public void 정상적으로_저장되어야_한다() {
        String test = eventStore.save(new DomainTestEvent("test"));
        Assert.assertNotNull(test);
    }


}