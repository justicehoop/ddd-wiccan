package com.woowahan.wiccan.management.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 광고 소제로써의 업소정보
 * Created by justicehoop on 2017. 4. 3..
 */
@Entity
@Getter
public class AdShop {
    @Id
    private String shopId;
    private String name;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<AdCategory> categories = new ArrayList<>();
    /**
     * 광고용 주소
     */
    @Embedded
    private Address address;


    public static AdShop createOf(String shopId, String name) {
        AdShop instance = new AdShop();
        instance.shopId = shopId;
        instance.name = name;
        return instance;
    }
}
