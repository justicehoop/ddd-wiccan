package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.management.dto.AdCancelCommand;
import com.woowahan.wiccan.management.dto.AdConfirmRejectCommand;
import com.woowahan.wiccan.management.dto.AdRefundCommand;
import com.woowahan.wiccan.management.dto.ListingAdDto;
import com.woowahan.wiccan.management.entity.ListingAd;
import com.woowahan.wiccan.management.ex.ResourceNotFoundException;
import com.woowahan.wiccan.management.repository.ListingAdRepository;
import com.woowahan.wiccan.management.service.AdStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 광고상태 관리 기능 제공
 * Created by justicehoop on 2017. 4. 5..
 */
@Service
public class AdStatusServiceImpl implements AdStatusService {

    @Autowired
    private ListingAdRepository listingAdRepository;

    @Override
    public ListingAdDto confirm(Long adId) {
        ListingAd ad = findValidAd(adId);
        return ListingAdDto.of(listingAdRepository.save(ad.confirmed()));
    }

    @Override
    public ListingAdDto reject(Long adId, AdConfirmRejectCommand command) {
        ListingAd ad = findValidAd(adId);
        return ListingAdDto.of(ad.reject(command.getRejectReason()));
    }

    @Override
    public ListingAdDto refund(Long adId, AdRefundCommand command) {
        ListingAd ad = findValidAd(adId);
        return ListingAdDto.of(ad.refund());
    }

    @Override
    public ListingAdDto cancel(Long adId, AdCancelCommand command) {
        ListingAd ad = findValidAd(adId);
        return ListingAdDto.of(ad.cancel());
    }

    private ListingAd findValidAd(Long adId) {
        return Optional.ofNullable(listingAdRepository.findOne(adId))
                       .orElseThrow(() -> new ResourceNotFoundException(String.format("ad[id:%d] does not exist", adId)));
    }
}
