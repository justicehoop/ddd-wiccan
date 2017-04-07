package com.woowahan.wiccan.impression.controller;

import com.woowahan.wiccan.impression.dto.GeoBasedListingAdSearchCommand;
import com.woowahan.wiccan.impression.dto.ListingAdDto;
import com.woowahan.wiccan.impression.entity.AdProductType;
import com.woowahan.wiccan.impression.service.GeoBasedAdImpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@RestController
@RequestMapping(value="/v1/api/ad")
public class AdImpressionController {
    @Autowired
    private GeoBasedAdImpressionService geoBasedAdImpressionService;

    @GetMapping(value = "/ultracall")
    public List<ListingAdDto> findUltraCallAds(@ModelAttribute  GeoBasedListingAdSearchCommand command) {
        return geoBasedAdImpressionService.searchListingAds(AdProductType.ULTRA_CALL, command);
    }

}
