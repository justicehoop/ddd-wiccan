package com.woowahan.wiccan.core.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
@Entity
@Getter
public class ListingAdStatus {
    @Id
    private Long adId;
    @OneToOne
    private ListingAd ad;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.REQ_ING;


    public enum Status {
        REQ_ING("신청중"),
        REQ_CONFIRM("승인요청"),
        REJECT("반려"),
        CONFIRMED("승인완료"),
        ING("집행중"),
        STOP("집행중지"),
        CANCEL("취소");

        private String desc;

        Status(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    ListingAdStatus() { }

    private ListingAdStatus changeStatus(Status status) {
        this.status = status;
        return this;
    }

    ListingAdStatus reqConfirm() {
        changeStatus(Status.REQ_CONFIRM);
        return this;
    }

    ListingAdStatus confirmed() {
        changeStatus(Status.CONFIRMED);
        return this;
    }

    ListingAdStatus reject() {
        changeStatus(Status.REJECT);
        return this;
    }

    ListingAdStatus changeToIng() {
        changeStatus(Status.ING);
        return this;
    }

    ListingAdStatus stop() {
        changeStatus(Status.STOP);
        return this;
    }

    ListingAdStatus cancel() {
        changeStatus(Status.CANCEL);
        return this;
    }

    public static ListingAdStatus createOf(ListingAd ad, Date startDate, Date endDate) {
        ListingAdStatus instance = new ListingAdStatus();
        instance.ad = ad;
        instance.startDate = startDate;
        instance.endDate = endDate;
        instance.status = Status.REQ_ING;
        return instance;
    }

}
