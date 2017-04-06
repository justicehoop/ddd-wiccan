package com.woowahan.wiccan.management.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.*;

/**
 * 광고 상태를 관리하는 Class -> ListingAd Object에서 사용됨 (Embedable)
 * Created by justicehoop on 2017. 4. 4..
 */
@Embeddable
@Getter
public class ListingAdStatus {
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.REQ_ING;
    private String rejectReason;


    public enum Status {
        REQ_ING("신청중"),
        REQ_CONFIRM("승인요청"),
        REJECT("반려"),
        CONFIRMED("승인완료"),
        ING("집행중"),
        STOP("집행중지"),
        FINISH("집행완료"),
        REFUND_FINISH("환불완료"),
        CANCEL("취소");

        private static final List<Status> REFUNDABLE_STATUSES = Collections.unmodifiableList(Arrays.asList(REQ_CONFIRM, CONFIRMED, ING, STOP));
        private static final List<Status> CANCELABLE_STATUSES = Collections.unmodifiableList(Arrays.asList(REQ_ING, REQ_CONFIRM, REJECT, CONFIRMED));

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

    ListingAdStatus refund() {
        changeStatus(Status.REFUND_FINISH);
        return this;
    }

    private boolean isConfirmed() {
        return status == Status.CONFIRMED;
    }

    ListingAdStatus ing() {
        if (!isConfirmed()) {
            throw new IllegalStateException("status must be 'CONFIRMED'");
        }

        changeStatus(Status.ING);
        return this;
    }

    ListingAdStatus stop() {
        if (isIng()) {
            throw new IllegalStateException("status must be 'ING'");
        }
        changeStatus(Status.STOP);
        return this;
    }

    private boolean isCancelable() {
        return Status.CANCELABLE_STATUSES.contains(status);
    }

    ListingAdStatus cancel() {
        if (!isCancelable()) {
            throw new IllegalStateException(String.format("%s status does not change to cancel"));
        }
        changeStatus(Status.CANCEL);
        return this;
    }

    private boolean isIng() {
        return status == Status.ING;
    }

    ListingAdStatus finish() {
        if (!isIng()) {
            throw new IllegalStateException("status must be 'ING'");
        }
        endDate = new Date();
        changeStatus(Status.FINISH);
        return this;
    }


    public static ListingAdStatus createOf(ListingAd ad, Date startDate, Date endDate) {
        ListingAdStatus instance = new ListingAdStatus();
        instance.startDate = startDate;
        instance.endDate = endDate;
        instance.status = Status.REQ_ING;
        return instance;
    }

}
