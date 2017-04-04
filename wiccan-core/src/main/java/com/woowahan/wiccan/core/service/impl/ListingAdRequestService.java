package com.woowahan.wiccan.core.service.impl;

import com.woowahan.wiccan.core.dto.ListingAdRequestCommand;
import com.woowahan.wiccan.core.dto.ListingAdRequestResult;
import com.woowahan.wiccan.core.repository.ListingAdRepository;
import com.woowahan.wiccan.core.service.AdRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
@Service
public class ListingAdRequestService implements AdRequestService<ListingAdRequestCommand, ListingAdRequestResult> {

    @Autowired
    private ListingAdRepository listingAdRepository;

    @Override
    public ListingAdRequestResult applyFor(ListingAdRequestCommand command) {
        return null;
    }
}
