package com.woowahan.wiccan.management.service;

import com.woowahan.wiccan.management.entity.ListingAd;

/**
 * 광고금액 결제 확인완료
 * Created by justicehoop on 2017. 4. 18..
 */
public interface AdConfirmationOfPaymentService {
    ListingAd confirm(Long adId);
}
