package com.woowahan.wiccan.management.entity.strategy;

import com.woowahan.wiccan.management.entity.AdProduct;

/**
 * 광고 관련 Entity에서 사용 하는 환불금액 계산 Strategy 생성 Helper class
 * 환불 전략 Factory (광고 상품 가격 모델에 따른 전략 생성)
 * Created by justicehoop on 2017. 4. 5..
 */
public abstract class RefundStrategyFactory {

    public static RefundStrategy create(AdProduct product) {
        AdProduct.CostModel costModel = product.getCostModel();
        switch(costModel) {
            case CPT:
                return new CptCostModelRefundStrategy();
            case CPC:
                return new NoRefundStrategy();
            default:
                throw new IllegalArgumentException(String.format("strategy for %s product that does not support", product.getCostModel()));
        }
    }
}
