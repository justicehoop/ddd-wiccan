package com.woowahan.management.api.controller;

import com.woowahan.wiccan.management.dto.AdCancelCommand;
import com.woowahan.wiccan.management.dto.AdConfirmRejectCommand;
import com.woowahan.wiccan.management.dto.ListingAdDto;
import com.woowahan.wiccan.management.dto.ListingAdRequestCommand;
import com.woowahan.wiccan.management.service.AdRequestService;
import com.woowahan.wiccan.management.service.AdStatusManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@RequestMapping(value = "/v1/ad")
@RestController
public class ListingAdController {

    @Autowired
    private AdRequestService<ListingAdRequestCommand, ListingAdDto> listingAdRequestService;
    @Autowired
    private AdStatusManageService adStatusManageService;

    @PostMapping("")
    public ListingAdDto requestAd(@RequestBody ListingAdRequestCommand command) {
        return listingAdRequestService.applyFor(command);
    }

    @PutMapping("/{adId}/request-confirm")
    public ListingAdDto requestConfirm(@PathVariable("adId") Long adId) {
        return adStatusManageService.confirm(adId);
    }

    @PutMapping("/{adId}/reject-confirm")
    public ListingAdDto rejectConfirm(@PathVariable("adId") Long adId, @ModelAttribute AdConfirmRejectCommand command) {
        return adStatusManageService.reject(adId, command);
    }

    @PutMapping("/{adId}/cancel")
    public ListingAdDto cancel(@PathVariable("adId") Long adId, @ModelAttribute AdCancelCommand command) {
        return adStatusManageService.cancel(adId, command);
    }

}
