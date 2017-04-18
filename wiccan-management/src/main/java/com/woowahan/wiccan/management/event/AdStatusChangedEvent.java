package com.woowahan.wiccan.management.event;

import com.woowahan.wiccan.commons.event.sourcing.DomainEvent;
import com.woowahan.wiccan.commons.type.AdStatus;
import com.woowahan.wiccan.management.entity.ListingAd;
import lombok.Getter;

/**
 * 광고 상태 변경 Event
 * Created by justicehoop on 2017. 4. 5..
 */
@Getter
public class AdStatusChangedEvent extends DomainEvent {
    private Long adId;
    private AdStatus adStatus;
    /**
     * Create a new DomainEvent.
    */
    public AdStatusChangedEvent(ListingAd ad) {
        super(ad.getId());
        this.adId = ad.getId();
        this.adStatus = ad.getAdStatus();
    }
}
