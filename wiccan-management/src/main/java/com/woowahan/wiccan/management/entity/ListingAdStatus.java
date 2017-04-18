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



    ListingAdStatus() { }


//    public static ListingAdStatus createOf(ListingAd ad, Date startDate, Date endDate) {
//        ListingAdStatus instance = new ListingAdStatus();
//        instance.startDate = startDate;
//        instance.endDate = endDate;
//        instance.adStatus = AdStatus.REQ_ING;
//        return instance;
//    }
//
//    public void setStatus(AdStatus status) {
//        this.adStatus = status;
//    }
}
