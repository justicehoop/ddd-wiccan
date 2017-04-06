package com.woowahan.wiccan.management.entity.strategy;

import com.woowahan.wiccan.management.entity.ListingAd;

/**
 * 환불 전략
 * Created by justicehoop on 2017. 4. 5..
 */
public interface RefundStrategy {
    Integer refund(ListingAd ad);
}
