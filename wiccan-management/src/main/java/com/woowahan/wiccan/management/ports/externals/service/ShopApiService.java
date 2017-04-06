package com.woowahan.wiccan.management.ports.externals.service;

import com.woowahan.wiccan.management.ports.externals.model.Shop;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public interface ShopApiService {

    Shop findById(String shopId);
}
