package com.woowahan.wiccan.core.service.impl;

import com.woowahan.wiccan.core.entity.ListingAd;
import com.woowahan.wiccan.core.entity.PaymentTransaction;
import com.woowahan.wiccan.core.service.RefundStrategy;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public class CptCostModelRefundStrategy implements RefundStrategy {

    @Override
    public Integer refund(ListingAd ad) {
        PaymentTransaction paymentTransaction = ad.getPaymentTransaction();
        paymentTransaction.getPaidPrice();
        return null;
    }
}
