package com.woowahan.wiccan.management.entity.rule.refund;

import com.woowahan.wiccan.management.entity.ListingAd;

/**
 * 환불 없음 (후불제 상품의 경우 환불 없음)
 * Created by justicehoop on 2017. 4. 6..
 */
public class DefferedRefundRule implements RefundRule {

    DefferedRefundRule() {}

    @Override
    public Integer refund(ListingAd ad) {
        return 0;
    }
}
