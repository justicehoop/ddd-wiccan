package com.woowahan.wiccan.core.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.*;

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
    private String rejectReason;

    private static final Date DEFAULT_END_DATE = new Calendar.Builder().setDate(9999,12,31).build().getTime();

    public enum Status {
        REQ_ING("신청중"),
        REQ_CONFIRM("승인요청"),
        REJECT("반려"),
        CONFIRMED("승인완료"),
        ING("집행중"),
        STOP("집행중지"),
        FINISH("집행완료"),
        CANCEL("취소");

        private static final List<Status> REFUNDABLE_STATUSES = Collections.unmodifiableList(Arrays.asList(REQ_CONFIRM, CONFIRMED, ING));

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

    public boolean isRefundable() {
        if (Status.REFUNDABLE_STATUSES.contains(status)) {
            return true;
        }
        return false;
    }

    ListingAdStatus reqConfirm() {
        changeStatus(Status.REQ_CONFIRM);
        return this;
    }

    ListingAdStatus confirmed() {
        changeStatus(Status.CONFIRMED);
        return this;
    }

    ListingAdStatus reject(String rejectReason) {
        changeStatus(Status.REJECT);
        this.rejectReason = rejectReason;
        return this;
    }

    ListingAdStatus ing() {
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

    ListingAdStatus finish() {
        endDate = new Date();
        changeStatus(Status.FINISH);
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

    public static ListingAdStatus createOf(ListingAd ad, Date startDate) {
        return createOf(ad, startDate, DEFAULT_END_DATE);
    }

}
