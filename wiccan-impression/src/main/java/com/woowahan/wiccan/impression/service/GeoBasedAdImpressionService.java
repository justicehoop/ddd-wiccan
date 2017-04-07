package com.woowahan.wiccan.impression.service;

import com.woowahan.wiccan.impression.dto.GeoBasedListingAdSearchCommand;
import com.woowahan.wiccan.impression.dto.ListingAdDto;
import com.woowahan.wiccan.impression.entity.AdProductType;
import com.woowahan.wiccan.impression.repository.AdRepository;

import java.util.List;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
public interface GeoBasedAdImpressionService {
    List<ListingAdDto> searchListingAds(AdProductType adProductType, GeoBasedListingAdSearchCommand command);
}
