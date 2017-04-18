package com.woowahan.wiccan.management.entity.rule.period;

import com.woowahan.wiccan.management.entity.ListingAd;

/**
 * Created by justicehoop on 2017. 4. 18..
 */
public abstract class AdPeriodPolicyFactory {

    public static AdPeriodPolicy getPolicy(ListingAd.RequestType requestType) {
        switch (requestType) {
            case NORMAL:
                return new NormalAdRequestStartDatePolicy();
            case RAPIDLY:
                return new RapidAdRequestPeriodPolicy();
            default:
                throw new IllegalArgumentException(String.format("period policy for %s requestType that does not support", requestType));
        }
    }
}
