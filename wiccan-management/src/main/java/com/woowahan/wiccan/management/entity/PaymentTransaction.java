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
    private DayOfPayment dayOfPayment = DayOfPayment.DAY_5;

    public enum DayOfPayment {
        DAY_5("매월 5일"),
        DAY_15("매월 15일"),
        DAY_25("매월 25일");

        private final String desc;

        DayOfPayment(String desc) {
            this.desc = desc;
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
        ad.amendPaymentTrasnaction(instance);
        return  instance;
    }

}
