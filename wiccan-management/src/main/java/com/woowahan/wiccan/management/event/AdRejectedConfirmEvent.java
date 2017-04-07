package com.woowahan.wiccan.management.event;

import com.woowahan.wiccan.commons.event.sourcing.DomainEvent;
import com.woowahan.wiccan.management.entity.ListingAd;
import com.woowahan.wiccan.management.entity.ListingAdStatus;
import lombok.Getter;

/**
 * 광고 승인 거절 이벤트
 * Created by justicehoop on 2017. 4. 5..
 */
@Getter
public class AdRejectedConfirmEvent extends DomainEvent {
    private Long adId;
    private ListingAdStatus.Status status;
    private String rejectReason;

    public AdRejectedConfirmEvent(ListingAd ad) {
        super(ad.getId());
        ListingAdStatus status = ad.getStatus();
        this.adId = ad.getId();
        this.status = status.getStatus();
        this.rejectReason = status.getRejectReason();
    }
}
