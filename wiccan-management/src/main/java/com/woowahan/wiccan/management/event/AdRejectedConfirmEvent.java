package com.woowahan.wiccan.management.event;

import com.woowahan.wiccan.commons.event.sourcing.DomainEvent;
import com.woowahan.wiccan.commons.type.AdStatus;
import com.woowahan.wiccan.management.entity.ListingAd;
import lombok.Getter;

/**
 * 광고 승인 거절 이벤트
 * Created by justicehoop on 2017. 4. 5..
 */
@Getter
public class AdRejectedConfirmEvent extends DomainEvent {
    private Long adId;
    private AdStatus adStatus;
    private String rejectReason;

    public AdRejectedConfirmEvent(ListingAd ad) {
        super(ad.getId());
        this.adId = ad.getId();
        this.adStatus = ad.getAdStatus();
        this.rejectReason = ad.getRejectReason();
    }
}
