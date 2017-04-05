package com.woowahan.wiccan.core.ports.externals.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
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


    public static Shop of(String shopId,
                          String name,
                          String tel,
                          String ownerName) {
        Shop shop = new Shop();
        shop.shopId = shopId;
        shop.name = name;
        shop.tel = tel;
        shop.ownerName = ownerName;
        return shop;
    }


}
