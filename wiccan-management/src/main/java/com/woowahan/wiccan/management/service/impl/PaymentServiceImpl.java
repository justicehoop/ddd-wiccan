package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.management.dto.PaymentResult;
import com.woowahan.wiccan.management.entity.PaymentMethod;
import com.woowahan.wiccan.management.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResult pay(PaymentMethod method, Integer price) {
        return new PaymentResult();
    }

}
