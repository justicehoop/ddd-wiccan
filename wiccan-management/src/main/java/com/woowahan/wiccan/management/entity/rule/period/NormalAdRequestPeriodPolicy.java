package com.woowahan.wiccan.management.entity.rule.period;

import com.woowahan.wiccan.commons.utils.DateUtils;
import com.woowahan.wiccan.management.entity.PaymentTransaction;

import java.time.LocalDate;
import java.util.Date;

/**
 * 일반광고 기간 정책
 * Created by justicehoop on 2017. 4. 18..
 */
public class NormalAdRequestPeriodPolicy implements AdPeriodPolicy {

    @Override
    public AdPeriod getPeriod(PaymentTransaction.DayOfPayment dayOfPayment, Integer contractDays) {
        Date startDate = getAvailableStartDate(dayOfPayment);
        Date endDate = DateUtils.plusDaysAsDate(startDate, contractDays);
        return AdPeriod.of(startDate, endDate);
    }

    private Date getAvailableStartDate(PaymentTransaction.DayOfPayment dayOfPayment) {
        LocalDate now = LocalDate.now();
        int dayOfMonth = now.getDayOfMonth();
        int month = now.getMonthValue();

        if (isPassed(dayOfPayment.getDayOfMonth(), dayOfMonth)) {
            LocalDate nextMonth = now.plusMonths(1);
            month = nextMonth.getMonthValue();
        }

        return DateUtils.asDate(LocalDate.of(now.getYear(), month, dayOfPayment.getDayOfMonth()));
    }

    private boolean isPassed(Integer paymentDay, int nowDay) {
        return paymentDay > nowDay;
    }
}
