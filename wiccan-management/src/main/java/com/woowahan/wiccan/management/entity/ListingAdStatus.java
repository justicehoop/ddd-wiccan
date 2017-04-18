package com.woowahan.wiccan.management.entity;

import com.woowahan.wiccan.commons.type.AdStatus;
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
    private AdStatus adStatus = AdStatus.REQ_ING;
    private String rejectReason;



    ListingAdStatus() { }

    private ListingAdStatus changeStatus(AdStatus adStatus) {
        this.adStatus = adStatus;
        return this;
    }

    public boolean isRefundable() {
        if (AdStatus.REFUNDABLE_STATUSES.contains(adStatus)) {
            return true;
        }
        return false;
    }

    ListingAdStatus reqConfirm() {
        checkConfirmable();
        changeStatus(AdStatus.REQ_CONFIRM);
        return this;
    }

    private void checkConfirmable() {
        if (adStatus != AdStatus.REQ_CONFIRM) {
            throw new IllegalStateException("Ad status must be 'REQ_CONFIRM'");
        }
    }

    ListingAdStatus amendPeriod(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        return this;
    }

    ListingAdStatus confirmed() {
        checkConfirmable();
        changeStatus(AdStatus.CONFIRMED);
        return this;
    }


    private void checkRejectable() {
        if (adStatus != AdStatus.REQ_CONFIRM) {
            throw new IllegalStateException("Ad status must be 'REQ_CONFIRM'");
        }
    }

    ListingAdStatus reject(String rejectReason) {
        checkRejectable();
        changeStatus(AdStatus.REJECT);
        this.rejectReason = rejectReason;
        return this;
    }

    ListingAdStatus refund() {
        changeStatus(AdStatus.REFUND_FINISH);

        return this;
    }

    private void checkChangeToIng() {
        if (adStatus == AdStatus.CONFIRMED || adStatus == AdStatus.STOP) {
            return;
        }

        throw new IllegalStateException("adStatus must be 'CONFIRMED' or 'STOP'");
    }

    ListingAdStatus ing() {
        checkChangeToIng();
        changeStatus(AdStatus.ING);
        return this;
    }


    ListingAdStatus stop() {
        if (!isIng()) {
            throw new IllegalStateException("status must be 'ING'");
        }
        changeStatus(AdStatus.STOP);
        return this;
    }

    private void checkCancelable() {
        if (!AdStatus.CANCELABLE_STATUSES.contains(adStatus)) {
            throw new IllegalStateException("status must be CANCELABLE_STATUSES");
        }
    }

    ListingAdStatus cancel() {
        checkCancelable();
        changeStatus(AdStatus.CANCEL);
        return this;
    }

    private boolean isIng() {
        return adStatus == AdStatus.ING;
    }

    ListingAdStatus finish() {
        if (!isIng()) {
            throw new IllegalStateException("status must be 'ING'");
        }
        endDate = new Date();
        changeStatus(AdStatus.FINISH);
        return this;
    }


    public static ListingAdStatus createOf(ListingAd ad, Date startDate, Date endDate) {
        ListingAdStatus instance = new ListingAdStatus();
        instance.startDate = startDate;
        instance.endDate = endDate;
        instance.adStatus = AdStatus.REQ_ING;
        return instance;
    }

    public void setStatus(AdStatus status) {
        this.adStatus = status;
    }
}
