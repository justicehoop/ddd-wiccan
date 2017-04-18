package com.woowahan.wiccan.management.ports.externals.service.impl;

/**
 * Created by justicehoop on 2017. 4. 14..
 */
public class AdImpressionSyncFailedException extends RuntimeException {

    public AdImpressionSyncFailedException() { }

    public AdImpressionSyncFailedException(String msg) {
        super(msg);
    }

    public AdImpressionSyncFailedException(String msg, Throwable t) {
        super(msg, t);
    }
}
