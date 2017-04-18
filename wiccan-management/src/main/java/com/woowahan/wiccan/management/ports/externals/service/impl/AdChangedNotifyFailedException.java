package com.woowahan.wiccan.management.ports.externals.service.impl;

/**
 * Created by justicehoop on 2017. 4. 14..
 */
public class AdChangedNotifyFailedException extends RuntimeException {

    public AdChangedNotifyFailedException() { }

    public AdChangedNotifyFailedException(String msg) {
        super(msg);
    }

    public AdChangedNotifyFailedException(String msg, Throwable t) {
        super(msg, t);
    }
}
