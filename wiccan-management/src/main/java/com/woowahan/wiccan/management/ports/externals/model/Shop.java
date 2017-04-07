package com.woowahan.wiccan.management.ports.externals.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 업주 정보 (업주/업소 시스템)
 * Created by justicehoop on 2017. 4. 5..
 */
@NoArgsConstructor
@Getter
@Setter
public class Shop {
    private String shopId;
    private String name;
    private String tel;
    private String ownerName;
    private String shopImage;


    public static Shop of(String shopId,
                          String name,
                          String tel,
                          String ownerName,
                          String shopImage) {
        Shop shop = new Shop();
        shop.shopId = shopId;
        shop.name = name;
        shop.tel = tel;
        shop.ownerName = ownerName;
        shop.shopImage = shopImage;
        return shop;
    }


}
