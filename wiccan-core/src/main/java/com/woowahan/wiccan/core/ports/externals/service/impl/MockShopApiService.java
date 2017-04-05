package com.woowahan.wiccan.core.ports.externals.service.impl;

import com.woowahan.wiccan.core.ports.externals.model.Shop;
import com.woowahan.wiccan.core.ports.externals.service.ShopApiService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@Profile("default")
@Service
public class MockShopApiService implements ShopApiService {

    @Override
    public Shop findById(String shopId) {
        return Shop.of(shopId, "test" + shopId, "000-000-000", "owner" + shopId);
    }
}
