package com.woowahan.wiccan.core.service.impl;

import com.woowahan.wiccan.core.dto.AdCancelCommand;
import com.woowahan.wiccan.core.dto.AdConfirmRejectCommand;
import com.woowahan.wiccan.core.dto.ListingAdDto;
import com.woowahan.wiccan.core.entity.ListingAd;
import com.woowahan.wiccan.core.ex.ResourceNotFoundException;
import com.woowahan.wiccan.core.repository.ListingAdRepository;
import com.woowahan.wiccan.core.service.AdStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
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
    public ListingAdDto cancel(Long adId, AdCancelCommand command) {
        ListingAd ad = findValidAd(adId);
        return ListingAdDto.of(ad.cancel());
    }

    private ListingAd findValidAd(Long adId) {
        return Optional.ofNullable(listingAdRepository.findOne(adId))
                       .orElseThrow(() -> new ResourceNotFoundException(String.format("ad[id:%d] does not exist", adId)));
    }
}
