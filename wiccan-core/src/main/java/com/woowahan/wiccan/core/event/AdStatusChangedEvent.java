package com.woowahan.wiccan.core.event;

import com.woowahan.wiccan.commons.event.sourcing.DomainEvent;
import com.woowahan.wiccan.core.entity.ListingAdStatus;
import lombok.Getter;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Getter
public class AdStatusChangedEvent extends DomainEvent {
    private Long adId;
    private ListingAdStatus.Status status;
    /**
     * Create a new ApplicationEvent.
     */
    public AdStatusChangedEvent(ListingAdStatus listingAdStatus) {
        super();
        this.adId = listingAdStatus.getAdId();
        this.status = listingAdStatus.getStatus();
    }
}
