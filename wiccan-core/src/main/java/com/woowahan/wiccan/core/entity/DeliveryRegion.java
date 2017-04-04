package com.woowahan.wiccan.core.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 배달권역
 * Created by justicehoop on 2017. 4. 3..
 */
@Entity
@Getter
public class DeliveryRegion {
    @Id
    private String shopNo;
    @ManyToOne
    private Shop shop;
    private String dongAdminCode;
    private boolean deliverable;

    DeliveryRegion() { }

    public DeliveryRegion disable() {
        deliverable = false;
        return this;
    }

    public DeliveryRegion enable() {
        deliverable = true;
        return this;
    }

    public DeliveryRegion amendShop(Shop shop) {
        this.shopNo = shop.getShopNo();
        this.shop = shop;
        return this;
    }

    public static DeliveryRegion createOf(Shop shop, String dongAdminCode, boolean deliverable) {
        DeliveryRegion instance = new DeliveryRegion();
        instance.shopNo = shop.getShopNo();
        instance.dongAdminCode = dongAdminCode;
        instance.deliverable = deliverable;
        shop.addDeliveryRegion(instance);
        return instance;
    }
}
