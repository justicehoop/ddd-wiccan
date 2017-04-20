package com.woowahan.wiccan.management.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import com.woowahan.wiccan.commons.event.sourcing.DomainEventPublisher;
import com.woowahan.wiccan.commons.type.AdStatus;
import com.woowahan.wiccan.management.entity.rule.period.AdPeriod;
import com.woowahan.wiccan.management.entity.rule.period.AdPeriodPolicy;
import com.woowahan.wiccan.management.entity.rule.period.AdPeriodPolicyFactory;
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
    private static final Integer BASE_CONTRACT_DAYS = 30;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AdProduct adProduct;
    @ManyToOne(fetch = FetchType.LAZY)
    private AdAccount account;
    @ManyToOne
    private AdShop shop;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private AdStatus adStatus = AdStatus.REQ_ING;
    private String rejectReason;


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


    private ListingAd changeStatus(AdStatus adStatus) {
        this.adStatus = adStatus;
        return this;
    }

    public boolean isRefundable() {
        if (AdStatus.REFUNDABLE_STATUSES.contains(adStatus)) {
            return true;
        }
        return false;
    }

    ListingAd reqConfirm() {
        checkConfirmable();
        changeStatus(AdStatus.REQ_CONFIRM);
        return this;
    }

    private void checkConfirmable() {
        if (adStatus != AdStatus.REQ_CONFIRM) {
            throw new IllegalStateException("Ad status must be 'REQ_CONFIRM'");
        }
    }

    private void checkRejectable() {
        if (adStatus != AdStatus.REQ_CONFIRM) {
            throw new IllegalStateException("Ad status must be 'REQ_CONFIRM'");
        }
    }

    private ListingAd refund() {
        changeStatus(AdStatus.REFUND_FINISH);

        return this;
    }

    private void checkChangeToIng() {
        if (adStatus == AdStatus.CONFIRMED || adStatus == AdStatus.STOP) {
            return;
        }

        throw new IllegalStateException("adStatus must be 'CONFIRMED' or 'STOP'");
    }



    private void checkCancelable() {
        if (!AdStatus.CANCELABLE_STATUSES.contains(adStatus)) {
            throw new IllegalStateException("status must be CANCELABLE_STATUSES");
        }
    }


    private boolean isIng() {
        return adStatus == AdStatus.ING;
    }


    public ListingAd confirmed() {
        checkConfirmable();
        changeStatus(AdStatus.CONFIRMED);
        publishAdStatusChangedEvent();
        return this;
    }

    public ListingAd reject(String rejectReason) {
        checkRejectable();
        changeStatus(AdStatus.REJECT);
        this.rejectReason = rejectReason;

        publishAdStatusChangedEvent();
        DomainEventPublisher.instance().publishEvent(new AdRejectedConfirmEvent(this));
        return this;
    }

    public ListingAd ing() {
        checkChangeToIng();
        changeStatus(AdStatus.ING);
        publishAdStatusChangedEvent();
        return this;
    }

    public ListingAd stop() {
        if (!isIng()) {
            throw new IllegalStateException("status must be 'ING'");
        }
        changeStatus(AdStatus.STOP);

        publishAdStatusChangedEvent();
        return this;
    }

    public ListingAd cancel() {
        checkCancelable();
        changeStatus(AdStatus.CANCEL);
        publishAdStatusChangedEvent();
        return this;
    }

    public ListingAd finish() {
        if (!isIng()) {
            throw new IllegalStateException("status must be 'ING'");
        }
        endDate = new Date();
        changeStatus(AdStatus.FINISH);

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
        if (!isRefundable()) {
            throw new IllegalStateException("calcRefundPrice only....");
        }

        paymentTransaction.refund(refundPrice);
        refund();
        return this;
    }


    public Integer getPaidPrice() {
        return paymentTransaction.getPaidPrice();
    }

    public ListingAd confirmedDeposit() {
        this.paymentTransaction.paid();
        this.assignPeriod();
        this.reqConfirm();
        return this;
    }

    private void assignPeriod() {
        AdPeriodPolicy policy = AdPeriodPolicyFactory.getPolicy(requestType);
        AdPeriod period = policy.getPeriod(paymentTransaction.getDayOfPayment(), BASE_CONTRACT_DAYS);
        this.startDate = period.getStartDate();
        this.endDate = period.getEndDate();
    }


    public static ListingAd createOf(AdProduct adProduct,
                                     AdShop adShop,
                                     AdAccount account,
                                     PaymentMethod paymentMethod) {
        ListingAd instance = new ListingAd();
        instance.adProduct = adProduct;
        instance.account = account;
        instance.shop = adShop;
        instance.paymentTransaction = PaymentTransaction.of(instance, paymentMethod, adProduct.getPrice());
        return instance;
    }

}
