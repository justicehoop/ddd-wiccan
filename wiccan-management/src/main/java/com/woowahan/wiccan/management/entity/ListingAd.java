package com.woowahan.wiccan.management.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import com.woowahan.wiccan.commons.event.sourcing.DomainEventPublisher;
import com.woowahan.wiccan.management.entity.rule.refund.RefundRule;
import com.woowahan.wiccan.management.entity.rule.refund.RefundRuleFactory;
import com.woowahan.wiccan.management.event.AdRejectedConfirmEvent;
import com.woowahan.wiccan.management.event.AdStatusChangedEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

/**
 * 리스팅형 광고
 * Created by justicehoop on 2017. 4. 3..
 */
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
@Getter
public class ListingAd extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AdProduct adProduct;
    @ManyToOne(fetch = FetchType.LAZY)
    private AdAccount account;
    @ManyToOne
    private AdShop shop;
    @Embedded
    private ListingAdStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    private PaymentMethod paymentMethod;
    @OneToOne(fetch = FetchType.LAZY)
    private PaymentTransaction paymentTransaction;
    @Enumerated(EnumType.STRING)
    private RequestType requestType = RequestType.NORMAL;


    public enum RequestType {
        NORMAL("일반"),
        RAPIDLY("빠른");

        private String desc;

        RequestType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }


    ListingAd() {}

    private void publishAdStatusChangedEvent() {
        DomainEventPublisher.instance().publishEvent(new AdStatusChangedEvent(this));
    }

    public ListingAd confirmed() {
        status.confirmed();
        publishAdStatusChangedEvent();
        return this;
    }

    public ListingAd reject(String rejectReason) {
        status.reject(rejectReason);
        publishAdStatusChangedEvent();
        DomainEventPublisher.instance().publishEvent(new AdRejectedConfirmEvent(this));
        return this;
    }

    public ListingAd ing() {
        status.ing();
        publishAdStatusChangedEvent();
        return this;
    }

    public ListingAd stop() {
        status.stop();
        publishAdStatusChangedEvent();
        return this;
    }

    public ListingAd cancel() {
        status.cancel();
        publishAdStatusChangedEvent();
        return this;
    }

    public ListingAd finish() {
        status.finish();
        publishAdStatusChangedEvent();
        return this;
    }

    ListingAd amendPaymentTransaction(PaymentTransaction transaction) {
        this.paymentTransaction = transaction;
        return this;
    }

    public Integer calcRefundPrice() {
        RefundRule strategy = RefundRuleFactory.create(adProduct);
        return strategy.refund(this);
    }



    public ListingAd refund(Integer refundPrice) {
        if (!status.isRefundable()) {
            throw new IllegalStateException("calcRefundPrice only....");
        }

        paymentTransaction.refund(refundPrice);
        status.refund();
        return this;
    }

    public PaymentTransaction.DayOfPayment getDayOfPayment() {
        return paymentTransaction.getDayOfPayment();
    }

    public Integer getPaidPrice() {
        return paymentTransaction.getPaidPrice();
    }


    public static ListingAd createOf(AdProduct adProduct,
                                     AdShop adShop,
                                     AdAccount account,
                                     Date startDate,
                                     Date endDate,
                                     PaymentMethod paymentMethod) {
        ListingAd instance = new ListingAd();
        instance.adProduct = adProduct;
        instance.account = account;
        instance.shop = adShop;
        instance.status = ListingAdStatus.createOf(instance, startDate, endDate);
        instance.paymentMethod = paymentMethod;
        return instance;
    }

}
