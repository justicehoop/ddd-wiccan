package com.woowahan.wiccan.impression.dto;

import com.woowahan.wiccan.impression.entity.ListingAd;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@AllArgsConstructor(staticName = "of")
@Data
public class ListingAdDto {
    private Long adId;
    private String shopName;
    private String shopImage;

    public ListingAdDto() {}

    public static ListingAdDto of(ListingAd ad) {
        ListingAdDto instance = new ListingAdDto();
        instance.adId = ad.getAdId();
        instance.shopName = ad.getShopName();
        instance.shopImage = ad.getShopImage();
        return instance;
    }
}
