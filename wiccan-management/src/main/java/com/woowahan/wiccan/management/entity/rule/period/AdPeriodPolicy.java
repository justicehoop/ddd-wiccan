package com.woowahan.wiccan.management.entity.rule.period;

import com.woowahan.wiccan.management.entity.PaymentTransaction;

/**
 * 광고 기간 정책
 * Created by justicehoop on 2017. 4. 18..
 */
public interface AdPeriodPolicy {
    AdPeriod getPeriod(PaymentTransaction.DayOfPayment dayOfPayment, Integer contractDays);
}
