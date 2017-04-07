package com.woowahan.wiccan.impression.entity;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
public enum AdProductType {
    ULTRA_CALL("울트라콜", "AA"),
    POWER_CALL("파워콜", "BB");

    private final String desc;
    private final String productCode;

    AdProductType(String desc, String productCode) {
        this.desc = desc;
        this.productCode = productCode;
    }

    public String getDesc() {
        return desc;
    }

    public String getProductCode() {
        return productCode;
    }
}
