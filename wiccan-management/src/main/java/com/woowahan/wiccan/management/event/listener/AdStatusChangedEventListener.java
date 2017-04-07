package com.woowahan.wiccan.management.event.listener;

import com.woowahan.wiccan.commons.event.sourcing.DomainEventListener;
import com.woowahan.wiccan.management.event.AdStatusChangedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Service
public class AdStatusChangedEventListener implements DomainEventListener<AdStatusChangedEvent> {
    @Override
    public void onDomainEvent(AdStatusChangedEvent event) {

    }
}
