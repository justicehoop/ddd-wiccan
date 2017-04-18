package com.woowahan.wiccan.impression.repository.impl;

import com.woowahan.wiccan.commons.type.AdStatus;
import com.woowahan.wiccan.commons.utils.ValueCreator;
import com.woowahan.wiccan.impression.dto.GeoBasedListingAdSearchCommand;
import com.woowahan.wiccan.impression.entity.ListingAd;
import com.woowahan.wiccan.impression.repository.AdRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@Repository
public class ElastingSearchAdRepository implements AdRepository {

    @Override
    public List<ListingAd> findAll(String productCode, GeoBasedListingAdSearchCommand searchCommand) {
        List<ListingAd> ads = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ads.add(ListingAd.of(ValueCreator.randomLong(), ValueCreator.randomLong(), "http://woowahan1.vipweb.kr/cache/fw/thumb_fr/circle/2013022102/fr_thumb_332.jpg", ValueCreator.randomString(4), AdStatus.ING));
        }

        return ads;
    }
}
