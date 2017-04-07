package com.woowahan.wiccan.commons.event.sourcing;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
public class DomainEventMulticastFailedException extends RuntimeException {

    public DomainEventMulticastFailedException(String msg) {
        super(msg);
    }

    public DomainEventMulticastFailedException(String msg, Throwable t) {
        super(msg, t);
    }
}
