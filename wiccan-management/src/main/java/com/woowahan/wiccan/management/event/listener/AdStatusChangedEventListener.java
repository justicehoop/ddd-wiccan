package com.woowahan.wiccan.management.event.listener;

import com.woowahan.wiccan.commons.event.sourcing.DomainEventListener;
import com.woowahan.wiccan.management.event.AdStatusChangedEvent;
import com.woowahan.wiccan.management.ports.externals.service.AdChangedNotifyService;
import com.woowahan.wiccan.management.ports.externals.service.dto.AdStatusNotifyCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Service
public class AdStatusChangedEventListener implements DomainEventListener<AdStatusChangedEvent> {
    @Autowired
    private AdChangedNotifyService adChangedNotifyService;

    @Override
    public void onDomainEvent(AdStatusChangedEvent event) {
        adChangedNotifyService.notifyAdStatusChanged(AdStatusNotifyCommand.of(event.getAdId(), event.getAdStatus()));
    }
}
