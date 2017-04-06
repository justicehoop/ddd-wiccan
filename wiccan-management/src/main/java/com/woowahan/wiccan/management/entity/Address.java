package com.woowahan.wiccan.management.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * 주소(Value Object)
 * Created by justicehoop on 2017. 4. 3..
 */
@Embeddable
@Getter
@ToString
public class Address {
    private String dongAdminCode;
    private String detail;
    private Double lat;
    private Double lng;
    private String fullTextJibun;
    private String fullTextRoad;

    protected Address() {}

    public static Address of(String dongAdminCode, Double lat, Double lng, String detail) {
        Address instance = new Address();
        instance.dongAdminCode = dongAdminCode;
        instance.detail = detail;
        instance.lat = lat;
        instance.lng = lng;
        return instance;
    }
}
