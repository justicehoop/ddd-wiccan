package com.woowahan.wiccan.management.dto;

import com.woowahan.wiccan.commons.type.AdStatus;
import com.woowahan.wiccan.management.entity.ListingAd;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Getter
@Setter
public class ListingAdStatusDto {
    private Long adId;
    private Date startDate;
    private Date endDate;
    private AdStatus adStatus = AdStatus.REQ_ING;

    public static ListingAdStatusDto of(ListingAd ad) {
        ListingAdStatusDto instance = new ListingAdStatusDto();
        instance.startDate = ad.getStartDate();
        instance.endDate = ad.getEndDate();
        instance.adStatus = ad.getAdStatus();
        return instance;
    }
}
