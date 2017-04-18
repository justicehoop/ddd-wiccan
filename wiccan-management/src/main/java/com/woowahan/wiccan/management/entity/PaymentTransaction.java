package com.woowahan.wiccan.management.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

/**
 * 거래정보
 * Created by justicehoop on 2017. 4. 3..
 */
@EqualsAndHashCode(of = "adId", callSuper = false)
@Entity
@Getter
public class PaymentTransaction {
    @Id
    private Long adId;
    @JoinColumn(name = "ad_id_fk")
    @OneToOne(fetch = FetchType.LAZY)
    private ListingAd ad;
    @ManyToOne(fetch = FetchType.LAZY)
    private PaymentMethod paymentMethod;
    private Integer paidPrice;
    private Integer refundPrice = 0;
    @Enumerated(EnumType.STRING)
    private DayOfPayment dayOfPayment = DayOfPayment.DAY_5;
    @Enumerated(EnumType.STRING)
    private PaidStatus paidStatus = PaidStatus.NOT_PAID;



    public enum PaidStatus {
        PAID,
        NOT_PAID
    }

    public enum DayOfPayment {
        DAY_5(5, "매월 5일"),
        DAY_15(15, "매월 15일"),
        DAY_25(25, "매월 25일");

        private final Integer dayOfMonth;
        private final String desc;

        DayOfPayment(Integer dayOfMonth, String desc) {
            this.dayOfMonth = dayOfMonth;
            this.desc = desc;
        }

        public Integer getDayOfMonth() {
            return dayOfMonth;
        }
    }


    PaymentTransaction() {}

    public PaymentTransaction refund(Integer refundPrice) {
        this.refundPrice = refundPrice;
        return this;
    }

    public static PaymentTransaction of(ListingAd ad,PaymentMethod paymentMethod, Integer paidPrice) {
        PaymentTransaction instance = new PaymentTransaction();
        instance.adId = ad.getId();
        instance.ad = ad;
        instance.paymentMethod = paymentMethod;
        instance.paidPrice = paidPrice;
        ad.amendPaymentTransaction(instance);
        return  instance;
    }

    public PaymentTransaction paid() {
        this.paidStatus = PaidStatus.PAID;
        return this;
    }

}
