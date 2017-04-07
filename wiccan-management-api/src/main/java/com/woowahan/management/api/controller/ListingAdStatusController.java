package com.woowahan.management.api.controller;

import com.woowahan.wiccan.management.service.AdStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@RequestMapping(value="/v1/api/ad/{adId}/status")
@RestController
public class ListingAdStatusController {

    @Autowired
    private AdStatusService adStatusService;


}
