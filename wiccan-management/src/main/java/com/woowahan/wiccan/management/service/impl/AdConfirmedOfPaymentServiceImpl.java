package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.infrastructure.notification.NotificationService;
import com.woowahan.wiccan.management.entity.ListingAd;
import com.woowahan.wiccan.management.ex.ResourceNotFoundException;
import com.woowahan.wiccan.management.repository.ListingAdRepository;
import com.woowahan.wiccan.management.service.AdConfirmationOfPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 광고금액 결제 확인완료
 * Created by justicehoop on 2017. 4. 18..
 */
@Service
public class AdConfirmedOfPaymentServiceImpl implements AdConfirmationOfPaymentService {

    @Autowired
    private ListingAdRepository listingAdRepository;
    @Autowired
    private NotificationService notificationService;

    @Override
    public ListingAd confirm(Long adId) {
        ListingAd ad = findValidAd(adId);
        ad.confirmedDeposit();
        notificationService.send("번화번호","전화번호","결제완료");
        return ad;
    }

    private ListingAd findValidAd(Long adId) {
        return Optional.ofNullable(listingAdRepository.findOne(adId))
                        .orElseThrow(() -> new ResourceNotFoundException(String.format("ad[id:%d] does not exists!", adId)));
    }
}
