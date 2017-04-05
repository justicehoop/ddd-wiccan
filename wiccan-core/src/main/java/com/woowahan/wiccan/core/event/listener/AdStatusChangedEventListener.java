package com.woowahan.wiccan.core.event.listener;

import com.woowahan.wiccan.commons.event.sourcing.DomainEventListener;
import com.woowahan.wiccan.core.event.AdStatusChangedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Service
public class AdStatusChangedEventListener implements DomainEventListener<AdStatusChangedEvent> {
    @Override
    public void onDomainEvent(AdStatusChangedEvent event) {

    }
}
