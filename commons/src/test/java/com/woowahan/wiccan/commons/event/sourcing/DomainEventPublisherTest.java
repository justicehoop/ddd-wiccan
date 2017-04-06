package com.woowahan.wiccan.commons.event.sourcing;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@Slf4j
public class DomainEventPublisherTest {

    public TestableDomainEventListener<DomainTestEvent> domainTestEventDomainEventListener = new TestableDomainEventListener<DomainTestEvent>() {
        @Override
        public void onDomainEventInternal(DomainTestEvent event) {
            log.info("calle]d DomainTestEventListener:{}", event);
        }
    };

    @Test
    public void 이벤트리스너가_정상적으로_호출되어야_한다() {
        DomainEventPublisher.instance().addEventListener(domainTestEventDomainEventListener);

        DomainEventPublisher.instance().publishEvent(new DomainTestEvent("test"));
        DomainEventPublisher.instance().publishEvent(new DomainTestEvent("test"));
        log.info("callCount:{}", domainTestEventDomainEventListener.getCallCount());
        assertThat("call count는 2여야 한다", domainTestEventDomainEventListener.getCallCount(), is(2));
    }

    @Test
    public void EventType과_매칭되는_이벤트리스너가_정상적으로_호출되어야_한다() {
        TestableDomainEventListener<SubTestEvent> subTestEventListener = new TestableDomainEventListener<SubTestEvent>() {
            @Override
            public void onDomainEventInternal(SubTestEvent event) {
                log.info("calle]d DomainTestEventListener:{}", event);
            }
        };
        DomainEventPublisher.instance().addEventListener(domainTestEventDomainEventListener);
        DomainEventPublisher.instance().addEventListener(subTestEventListener);

        DomainEventPublisher.instance().publishEvent(new DomainTestEvent("test"));
        DomainEventPublisher.instance().publishEvent(new DomainTestEvent("test"));
        DomainEventPublisher.instance().publishEvent(new SubTestEvent("subTest"));

        log.info("callCount:{}", domainTestEventDomainEventListener.getCallCount());
        log.info("callCount:{}", subTestEventListener.getCallCount());

        assertThat("call count는 2여야 한다", domainTestEventDomainEventListener.getCallCount(), is(2));
        assertThat("call count는 2여야 한다", subTestEventListener.getCallCount(), is(1));
    }
}