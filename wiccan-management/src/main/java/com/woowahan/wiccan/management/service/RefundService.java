package com.woowahan.wiccan.management.service;

import com.woowahan.wiccan.management.entity.AdAccount;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
public interface RefundService {

    void refund(Long adId, AdAccount account, Integer refundPrice);
}
