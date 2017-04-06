package com.woowahan.wiccan.core.entity.strategy;

import com.woowahan.wiccan.core.entity.ListingAd;

/**
 * 환불 없음 (후불제 상품의 경우 환불 없음)
 * Created by justicehoop on 2017. 4. 6..
 */
public class NoRefundStrategy implements RefundStrategy {
    @Override
    public Integer refund(ListingAd ad) {
        return 0;
    }
}
