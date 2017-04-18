package com.woowahan.wiccan.management.entity.rule.period;

import com.woowahan.wiccan.management.entity.ListingAd;
import com.woowahan.wiccan.management.entity.PaymentTransaction;

/**
 * Created by justicehoop on 2017. 4. 18..
 */
public interface AdPeriodPolicy {
    AdPeriod getPeriod(PaymentTransaction.DayOfPayment dayOfPayment, Integer contractDays);
}
