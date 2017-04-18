package com.woowahan.wiccan.management.service;

import com.woowahan.wiccan.management.dto.PaymentResult;
import com.woowahan.wiccan.management.entity.PaymentMethod;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
public interface PaymentService {
    PaymentResult pay(PaymentMethod method, Integer price);
}
