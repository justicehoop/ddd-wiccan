package com.woowahan.wiccan.management.event;

import com.woowahan.wiccan.commons.event.sourcing.DomainEventPublisher;
import com.woowahan.wiccan.management.event.listener.AdRejectedConfirmEventListener;
import com.woowahan.wiccan.management.event.listener.AdStatusChangedEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Application Life cycle에 맞춰서 DomainEvent Listener 등록 및 해제를 수행
 * Created by justicehoop on 2017. 4. 5..
 */
@Component
public class ApplicationLifeCycle {
    @Autowired
    private AdRejectedConfirmEventListener adRejectedConfirmEventListener;
    @Autowired
    private AdStatusChangedEventListener adStatusChangedEventListener;

    @PostConstruct
    public void afterInitialized() {
        DomainEventPublisher.instance().addEventListener(adRejectedConfirmEventListener);
        DomainEventPublisher.instance().addEventListener(adStatusChangedEventListener);
    }

    @PreDestroy
    public void beforeDestroyed() {
        DomainEventPublisher.instance().removeAllListeners();
    }
}
