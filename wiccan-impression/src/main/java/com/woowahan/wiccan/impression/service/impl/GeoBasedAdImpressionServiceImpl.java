package com.woowahan.wiccan.impression.service.impl;

import com.woowahan.wiccan.impression.dto.GeoBasedListingAdSearchCommand;
import com.woowahan.wiccan.impression.dto.ListingAdDto;
import com.woowahan.wiccan.impression.entity.AdProductType;
import com.woowahan.wiccan.impression.repository.AdRepository;
import com.woowahan.wiccan.impression.service.GeoBasedAdImpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@Transactional
@Service
public class GeoBasedAdImpressionServiceImpl implements GeoBasedAdImpressionService {
    @Autowired
    private AdRepository adRepository;

    @Override
    public List<ListingAdDto> searchListingAd(AdProductType adProductType, GeoBasedListingAdSearchCommand command) {
        return adRepository.findAll(adProductType.getProductCode(), command)
                    .stream()
                    .map(ListingAdDto::of)
                    .collect(Collectors.toList());
    }


}
