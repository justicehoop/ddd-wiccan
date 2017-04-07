package com.woowahan.wiccan.commons.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by justicehoop on 2017. 4. 7..
 */

public enum AdStatus {
    REQ_ING("신청중"),
    REQ_CONFIRM("승인요청"),
    REJECT("반려"),
    CONFIRMED("승인완료"),
    ING("집행중"),
    STOP("집행중지"),
    FINISH("집행완료"),
    REFUND_FINISH("환불완료"),
    CANCEL("취소");

    public static final List<AdStatus> REFUNDABLE_STATUSES = Collections.unmodifiableList(Arrays.asList(REQ_CONFIRM, CONFIRMED, ING, STOP));
    public static final List<AdStatus> CANCELABLE_STATUSES = Collections.unmodifiableList(Arrays.asList(REQ_ING, REQ_CONFIRM, REJECT, CONFIRMED));

    private String desc;

    AdStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}