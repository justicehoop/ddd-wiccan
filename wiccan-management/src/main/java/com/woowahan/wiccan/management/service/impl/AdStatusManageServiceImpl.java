package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.infrastructure.notification.NotificationService;
import com.woowahan.wiccan.management.dto.AdCancelCommand;
import com.woowahan.wiccan.management.dto.AdConfirmRejectCommand;
import com.woowahan.wiccan.management.dto.AdRefundCommand;
import com.woowahan.wiccan.management.dto.ListingAdDto;
import com.woowahan.wiccan.management.entity.ListingAd;
import com.woowahan.wiccan.management.ex.ResourceNotFoundException;
import com.woowahan.wiccan.management.repository.ListingAdRepository;
import com.woowahan.wiccan.management.service.AdStatusManageService;
import com.woowahan.wiccan.management.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 광고상태 관리 기능 제공
 * @TODO: 광고 변경 히스토리 추가
 * Created by justicehoop on 2017. 4. 5..
 */
@Transactional
@Service
public class AdStatusManageServiceImpl implements AdStatusManageService {
    @Autowired
    private ListingAdRepository listingAdRepository;
    @Autowired
    private RefundService refundService;
    @Autowired
    private NotificationService notificationService;

    /**
     * Transaction script 예제
     * @param adId
     * @return
     */
    public ListingAdDto cancel(Long adId) {
        ListingAd ad = findValidAd(adId);

        Integer refundPrice = ad.calcRefundPrice();
//        status.setStatus(AdStatus.CANCEL);
        refundService.refund(ad.getId(), ad.getAccount(), refundPrice);
        // 외부서비스와 연동 되는 부분
        notificationService.send("1644-0025", ad.getAccount().getTelNo(), "광고 승인 거부");
        return ListingAdDto.of(ad);
    }

    @Override
    public ListingAdDto confirm(Long adId) {
        ListingAd ad = findValidAd(adId);
        return ListingAdDto.of(ad.confirmed());
    }

    @Override
    public ListingAdDto reject(Long adId, AdConfirmRejectCommand command) {
        ListingAd ad = findValidAd(adId);
        ad.reject(command.getRejectReason());
        return ListingAdDto.of(ad);
    }

    @Override
    public ListingAdDto refund(Long adId, AdRefundCommand command) {
        ListingAd ad = findValidAd(adId);

        Integer refundPrice = ad.calcRefundPrice();
        ad.refund(refundPrice);
        refundService.refund(ad.getId(),ad.getAccount(), refundPrice);
        return ListingAdDto.of(ad);
    }

    @Override
    public ListingAdDto cancel(Long adId, AdCancelCommand command) {
        ListingAd ad = findValidAd(adId);

        ad.cancel();
        refundService.refund(ad.getId(),ad.getAccount(), ad.getPaidPrice());
        return ListingAdDto.of(ad);
    }

    private ListingAd findValidAd(Long adId) {
        return Optional.ofNullable(listingAdRepository.findOne(adId))
                       .orElseThrow(() -> new ResourceNotFoundException(String.format("ad[id:%d] does not exist", adId)));
    }
}
