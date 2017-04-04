package com.woowahan.wiccan.core.entity;

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
public class Shop {
    @Id
    private String shopNo;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private List<ShopCategory> categories;
    /**
     * 광고용 주소
     */
    @Embedded
    private Address address;
    @ElementCollection
    private List<DeliveryRegion> deliveryRegions = new ArrayList<>();

    public Shop addDeliveryRegion(DeliveryRegion deliveryRegion) {
        deliveryRegion.amendShop(this);
        this.deliveryRegions.add(deliveryRegion);
        return this;
    }

    public static Shop createOf(String shopNo, String name, List<ShopCategory> categories) {
        Shop instance = new Shop();
        instance.shopNo = shopNo;
        instance.name = name;
        instance.categories = categories;
        return instance;
    }
}
