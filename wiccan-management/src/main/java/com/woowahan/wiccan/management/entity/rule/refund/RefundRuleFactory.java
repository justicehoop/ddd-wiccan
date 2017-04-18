package com.woowahan.wiccan.management.entity.rule.refund;

import com.woowahan.wiccan.management.entity.AdProduct;

/**
 * 광고 관련 Entity에서 사용 하는 환불금액 계산 Strategy 생성 Helper class
 * 환불 전략 Factory (광고 상품 가격 모델에 따른 전략 생성)
 * Created by justicehoop on 2017. 4. 5..
 */
public final class RefundRuleFactory {

    public static RefundRule create(AdProduct product) {
        AdProduct.CostModel costModel = product.getCostModel();
        switch(costModel) {
            case CPT:
                return new CptCostModelRefundRule();
            case CPC:
                return new DefferedRefundRule();
            default:
                throw new IllegalArgumentException(String.format("refund strategy for %s product that does not support", product.getCostModel()));
        }
    }
}
