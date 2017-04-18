package com.woowahan.wiccan.management.entity.rule.period;

import com.woowahan.wiccan.commons.utils.DateUtils;
import com.woowahan.wiccan.management.entity.PaymentTransaction;

import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 18..
 */
public class RapidAdRequestPeriodPolicy implements AdPeriodPolicy {

    private static final Integer START_DATE_TERMS_FROM_TODAY = 1;

    @Override
    public AdPeriod getPeriod(PaymentTransaction.DayOfPayment dayOfPayment, Integer contractDays) {
        Date nowDate = DateUtils.getNowDate();
        final Date startDate = DateUtils.plusDaysAsDate(nowDate, START_DATE_TERMS_FROM_TODAY);
        final Date endDate = DateUtils.plusDaysAsDate(startDate, contractDays);
        return AdPeriod.of(startDate, endDate);
    }
}
