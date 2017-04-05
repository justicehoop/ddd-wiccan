package com.woowahan.wiccan.core.dto;

import com.woowahan.wiccan.core.entity.ListingAdStatus;
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
    private ListingAdStatus.Status status = ListingAdStatus.Status.REQ_ING;

    public static ListingAdStatusDto of(ListingAdStatus status) {
        ListingAdStatusDto instance = new ListingAdStatusDto();
        instance.adId = status.getAdId();
        instance.startDate = status.getStartDate();
        instance.endDate = status.getEndDate();
        return instance;
    }
}
