package com.woowahan.wiccan.core.entity;

import lombok.Getter;

import javax.persistence.*;

/**
 *
 * Created by justicehoop on 2017. 4. 3..
 */
@Entity
@Getter
public class Payment {
    @Id
    private Long adId;
    @OneToOne
    private ListingAd ad;
    private Long paidPrice;
    private Long refundPrice = 0L;
    public PaymentMethod paymentMethod = PaymentMethod.AUTO_PAYMENT;



    public enum PaymentMethod {
        AUTO_PAYMENT("자동이체"),
        CARD("신용카드");

        private String desc;

        PaymentMethod(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return this.desc;
        }

    }

    Payment() {}

    public Payment refund(Long refundPrice) {
        this.refundPrice = refundPrice;
        return this;
    }

    public static Payment of(ListingAd ad, Long paidPrice) {
        Payment instance = new Payment();
        instance.adId = ad.getId();
        instance.ad = ad;
        instance.paidPrice = paidPrice;
        return  instance;
    }

}
