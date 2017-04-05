package com.woowahan.wiccan.core.event;

import com.woowahan.wiccan.commons.event.sourcing.DomainEventPublisher;
import com.woowahan.wiccan.core.event.listener.AdRejectedConfirmEventListener;
import com.woowahan.wiccan.core.event.listener.AdStatusChangedEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Component
public class EventListenerRegister {
    @Autowired
    private AdRejectedConfirmEventListener adRejectedConfirmEventListener;
    @Autowired
    private AdStatusChangedEventListener adStatusChangedEventListener;

    @PostConstruct
    public void afterInitialized() {
        DomainEventPublisher.instance().addEventListener(adRejectedConfirmEventListener);
        DomainEventPublisher.instance().addEventListener(adStatusChangedEventListener);

    }
}
