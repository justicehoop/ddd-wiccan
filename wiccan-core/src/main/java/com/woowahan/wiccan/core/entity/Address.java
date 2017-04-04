package com.woowahan.wiccan.core.entity;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * 주소(Value Object)
 * Created by justicehoop on 2017. 4. 3..
 */
@Embeddable
@Getter
public class Address {
    @Id
    private ListingAd listingAd;
    private String dongAdminCode;
    private String detail;
    private Double lat;
    private Double lng;
    private String fullTextJibun;
    private String fullTextRoad;

    public static Address of(ListingAd listingAd, String dongAdminCode, Double lat, Double lng, String detail) {
        Address instance = new Address();
        instance.listingAd = listingAd;
        instance.dongAdminCode = dongAdminCode;
        instance.detail = detail;
        instance.lat = lat;
        instance.lng = lng;
        return instance;
    }
}
