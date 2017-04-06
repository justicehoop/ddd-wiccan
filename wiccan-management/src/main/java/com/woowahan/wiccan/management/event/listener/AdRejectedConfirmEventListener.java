package com.woowahan.wiccan.management.event.listener;

import com.woowahan.wiccan.commons.event.sourcing.DomainEventListener;
import com.woowahan.wiccan.management.entity.AdAccount;
import com.woowahan.wiccan.management.entity.ListingAd;
import com.woowahan.wiccan.management.event.AdRejectedConfirmEvent;
import com.woowahan.wiccan.management.repository.ListingAdRepository;
import com.woowahan.wiccan.infrastructure.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Transactional(readOnly = true)
@Service
public class AdRejectedConfirmEventListener implements DomainEventListener<AdRejectedConfirmEvent> {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private ListingAdRepository listingAdRepository;


    @Override
    public void onDomainEvent(AdRejectedConfirmEvent event) {
        ListingAd ad = listingAdRepository.findOne(event.getAdId());
        AdAccount account = ad.getAccount();
        notificationService.send("000-000-0000", account.getTelNo(), "광고 승인이 거부 되었습니다");
    }

}
