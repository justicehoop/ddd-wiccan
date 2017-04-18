package com.woowahan.wiccan.impression.repository;

import com.woowahan.wiccan.impression.dto.GeoBasedListingAdSearchCommand;
import com.woowahan.wiccan.impression.entity.ListingAd;

import java.util.List;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
public interface AdRepository {
    List<ListingAd> findAll(String productCode, GeoBasedListingAdSearchCommand searchCommand);
}
