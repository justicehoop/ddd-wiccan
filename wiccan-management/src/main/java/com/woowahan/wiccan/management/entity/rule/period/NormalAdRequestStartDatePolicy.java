package com.woowahan.wiccan.management.entity.rule.period;

import com.woowahan.wiccan.commons.utils.DateUtils;
import com.woowahan.wiccan.management.entity.PaymentTransaction;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 18..
 */
public class NormalAdRequestStartDatePolicy implements AdPeriodPolicy {

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

        if (isPassed(dayOfPayment, dayOfMonth)) {
            LocalDate nextMonth = now.plusMonths(1);
            month = nextMonth.getMonthValue();
        }

        return DateUtils.asDate(LocalDate.of(now.getYear(), month, dayOfPayment.getDayOfMonth()));
    }

    private boolean isPassed(PaymentTransaction.DayOfPayment dayOfPayment, int nowDay) {
        return dayOfPayment.getDayOfMonth() > nowDay;
    }
}
