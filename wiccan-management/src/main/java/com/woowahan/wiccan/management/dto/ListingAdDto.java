package com.woowahan.wiccan.management.dto;

import com.woowahan.wiccan.management.entity.ListingAd;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
@Getter
@Setter
public class ListingAdDto {
    private Long id;
    private ListingAdStatusDto status;


    public static ListingAdDto of(ListingAd ad) {
        ListingAdDto instance = new ListingAdDto();
        instance.id = ad.getId();
        instance.status = ListingAdStatusDto.of(ad.getStatus());
        return instance;
    }

}
