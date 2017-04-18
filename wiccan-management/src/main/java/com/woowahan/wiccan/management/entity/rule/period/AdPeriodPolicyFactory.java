package com.woowahan.wiccan.management.entity.rule.period;

import com.woowahan.wiccan.management.entity.ListingAd;

/**
 * 광고기간 정책 Factory
 * Created by justicehoop on 2017. 4. 18..
 */
public final class AdPeriodPolicyFactory {

    public static AdPeriodPolicy getPolicy(ListingAd.RequestType requestType) {
        switch (requestType) {
            case NORMAL:
                return new NormalAdRequestPeriodPolicy();
            case RAPIDLY:
                return new RapidAdRequestPeriodPolicy();
            default:
                throw new IllegalArgumentException(String.format("period policy for %s requestType that does not support", requestType));
        }
    }
}
