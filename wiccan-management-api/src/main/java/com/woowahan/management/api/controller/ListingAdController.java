package com.woowahan.management.api.controller;

import com.woowahan.wiccan.management.dto.ListingAdDto;
import com.woowahan.wiccan.management.dto.ListingAdRequestCommand;
import com.woowahan.wiccan.management.service.AdRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@RequestMapping(value = "/v1/ad")
@RestController
public class ListingAdController {

    @Autowired
    private AdRequestService<ListingAdRequestCommand, ListingAdDto> listingAdRequestService;

    @PostMapping("")
    public ListingAdDto adRequest(@RequestBody ListingAdRequestCommand command) {
        return listingAdRequestService.applyFor(command);
    }

}
