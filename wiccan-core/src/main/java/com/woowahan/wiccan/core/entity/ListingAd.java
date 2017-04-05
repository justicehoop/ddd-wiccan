package com.woowahan.wiccan.core.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import com.woowahan.wiccan.commons.event.sourcing.DomainEventPublisher;
import com.woowahan.wiccan.core.event.AdRejectedConfirmEvent;
import com.woowahan.wiccan.core.event.AdStatusChangedEvent;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

/**
 * 리스팅형 광고
 * Created by justicehoop on 2017. 4. 3..
 */
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
    private AdShop adShop;
    @OneToMany(fetch = FetchType.LAZY)
    private ListingAdStatus status;
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
        DomainEventPublisher.instance().publishEvent(new AdStatusChangedEvent(status));
    }

    public ListingAd confirmed() {
        status.confirmed();
        publishAdStatusChangedEvent();
        return this;
    }

    public ListingAd reject(String rejectReason) {
        status.reject(rejectReason);
        publishAdStatusChangedEvent();
        DomainEventPublisher.instance().publishEvent(new AdRejectedConfirmEvent(status));
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

//    public Integer refund(Integer price) {
//        if (!status.isRefundable()) {
//            throw new IllegalStateException("refund only....");
//        }
//    }


    public static ListingAd createOf(AdProduct adProduct,
                                     AdShop adShop,
                                     AdAccount account,
                                     Date startDate,
                                     Date endDate,
                                     PaymentTransaction paymentTransaction) {
        ListingAd instance = new ListingAd();
        instance.adProduct = adProduct;
        instance.account = account;
        instance.adShop = adShop;
        instance.status = ListingAdStatus.createOf(instance, startDate, endDate);
        instance.paymentTransaction = paymentTransaction;
        return instance;
    }

}
