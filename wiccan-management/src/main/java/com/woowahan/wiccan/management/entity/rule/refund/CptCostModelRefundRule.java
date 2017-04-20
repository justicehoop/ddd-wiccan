package com.woowahan.wiccan.management.entity.rule.refund;

import com.woowahan.wiccan.commons.utils.DateUtils;
import com.woowahan.wiccan.management.entity.ListingAd;
import com.woowahan.wiccan.management.entity.PaymentTransaction;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

/**
 * Cpt 가격 정책에 대한 환불 전략
 * Created by justicehoop on 2017. 4. 5..
 */
public class CptCostModelRefundRule implements RefundRule {

    CptCostModelRefundRule() {}

    @Override
    public Integer refund(ListingAd ad) {
        Integer pricePerDay = calculatePricePerDay(ad);
        Integer remainDays = calculateRemainDays(ad);
        return remainDays * pricePerDay;
    }

    private Integer calculatePricePerDay(ListingAd ad) {
        PaymentTransaction paymentTransaction = ad.getPaymentTransaction();
        Integer paidPrice = paymentTransaction.getPaidPrice();

        Integer totalContractDays = getPeriodAsDay(ad.getStartDate(), ad.getEndDate());

        return (int) paidPrice / totalContractDays;
    }

    private Integer calculateRemainDays(ListingAd ad) {
        Date today = new Date();
        return getPeriodAsDay(today, ad.getEndDate());
    }

    private Integer getPeriodAsDay(Date from, Date to) {
        LocalDateTime fromDate = DateUtils.asLocalDateTime(from);
        LocalDateTime endDate = DateUtils.asLocalDateTime(to);
        Period period = Period.between(fromDate.toLocalDate(), endDate.toLocalDate());
        return period.getDays();
    }
}
