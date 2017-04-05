package com.woowahan.wiccan.core.event;

import com.woowahan.wiccan.commons.event.sourcing.DomainEvent;
import com.woowahan.wiccan.core.entity.ListingAdStatus;
import lombok.Getter;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Getter
public class AdRejectedConfirmEvent extends DomainEvent {
    private Long adId;
    private ListingAdStatus.Status status;
    private String rejectReason;

    public AdRejectedConfirmEvent(ListingAdStatus status) {
        this.adId = status.getAdId();
        this.status = status.getStatus();
        this.rejectReason = status.getRejectReason();
    }
}
