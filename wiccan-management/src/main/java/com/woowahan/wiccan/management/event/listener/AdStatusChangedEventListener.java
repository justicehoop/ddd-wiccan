package com.woowahan.wiccan.management.event.listener;

import com.woowahan.wiccan.commons.event.sourcing.DomainEventListener;
import com.woowahan.wiccan.management.event.AdStatusChangedEvent;
import com.woowahan.wiccan.management.ports.externals.service.AdImpressionSyncService;
import com.woowahan.wiccan.management.ports.externals.service.dto.AdSyncCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Service
public class AdStatusChangedEventListener implements DomainEventListener<AdStatusChangedEvent> {
    @Autowired
    private AdImpressionSyncService adImpressionSyncService;

    @Override
    public void onDomainEvent(AdStatusChangedEvent event) {
        adImpressionSyncService.syncStatus(AdSyncCommand.of(event.getAdId(), event.getAdStatus()));
    }
}
