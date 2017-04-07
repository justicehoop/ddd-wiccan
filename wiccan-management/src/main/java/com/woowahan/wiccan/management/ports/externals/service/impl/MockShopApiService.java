package com.woowahan.wiccan.management.ports.externals.service.impl;

import com.woowahan.wiccan.management.ports.externals.model.Shop;
import com.woowahan.wiccan.management.ports.externals.service.ShopApiService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Service
public class MockShopApiService implements ShopApiService {

    @Override
    public Shop findById(String shopId) {
        return Shop.of(shopId, "test" + shopId, "000-000-000", "owner" + shopId, "http://woowahan1.vipweb.kr/cache/fw/thumb_fr/circle/2013022102/fr_thumb_332.jpg");
    }
}
