package com.woowahan.wiccan.management.ex;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("shop does not exist!");
    }

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
