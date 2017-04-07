package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.management.entity.AdAccount;
import com.woowahan.wiccan.management.service.RefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@Transactional
@Slf4j
@Service
public class RefundServiceImpl implements RefundService {

    @Override
    public void refund(Long adId, AdAccount account, Integer refundPrice) {
        log.info("[환불완료] ->adId:{}, adAccount:{}, refundPrice:{}", adId, account.getAccountId(), refundPrice);
    }
}
