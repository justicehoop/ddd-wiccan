package com.woowahan.wiccan.core.service;

import com.woowahan.wiccan.core.entity.ListingAd;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public interface RefundStrategy {
    Integer refund(ListingAd ad);
}
