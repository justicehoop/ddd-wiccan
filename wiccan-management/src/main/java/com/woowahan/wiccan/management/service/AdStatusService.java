package com.woowahan.wiccan.management.service;

import com.woowahan.wiccan.management.dto.AdCancelCommand;
import com.woowahan.wiccan.management.dto.AdConfirmRejectCommand;
import com.woowahan.wiccan.management.dto.AdRefundCommand;
import com.woowahan.wiccan.management.dto.ListingAdDto;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public interface AdStatusService {

    ListingAdDto confirm(Long adId);

    ListingAdDto reject(Long adId, AdConfirmRejectCommand command);

    ListingAdDto refund(Long adId, AdRefundCommand command);

    ListingAdDto cancel(Long adId, AdCancelCommand command);
}
