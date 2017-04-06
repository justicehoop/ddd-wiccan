package com.woowahan.wiccan.core.service;

import com.woowahan.wiccan.core.dto.AdCancelCommand;
import com.woowahan.wiccan.core.dto.AdConfirmRejectCommand;
import com.woowahan.wiccan.core.dto.AdRefundCommand;
import com.woowahan.wiccan.core.dto.ListingAdDto;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public interface AdStatusService {

    ListingAdDto confirm(Long adId);

    ListingAdDto reject(Long adId, AdConfirmRejectCommand command);

    ListingAdDto refund(Long adId, AdRefundCommand command);

    ListingAdDto cancel(Long adId, AdCancelCommand command);
}
