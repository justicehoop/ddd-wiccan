package com.woowahan.wiccan.core.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private AdAccount account;
    @ManyToOne
    private Shop shop;
    @OneToMany(fetch = FetchType.LAZY)
    private ListingAdStatus listingAdStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    private Dsm dsm;
    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;


    ListingAd() {}


    ListingAd confirmed() {
        listingAdStatus.confirmed();
        return this;
    }

    ListingAd reject() {
        listingAdStatus.reject();
        return this;
    }

    ListingAd changeToIng() {
        listingAdStatus.changeToIng();
        return this;
    }

    ListingAd stop() {
        listingAdStatus.stop();
        return this;
    }

    ListingAd cancel() {
        listingAdStatus.cancel();
        return this;
    }


    public static ListingAd createOf(Shop shop,
                                     AdAccount account,
                                     Dsm dsm,
                                     Date startDate,
                                     Date endDate,
                                     Payment payment) {
        ListingAd instance = new ListingAd();
        instance.account = account;
        instance.shop = shop;
        instance.dsm = dsm;
        instance.listingAdStatus = ListingAdStatus.createOf(instance, startDate, endDate);
        instance.payment = payment;
        return instance;
    }

}
