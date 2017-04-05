package com.woowahan.wiccan.commons.event.sourcing;

import java.util.EventObject;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
public abstract class DomainEvent {

    /** use serialVersionUID from Spring 1.2 for interoperability */
    private static final long serialVersionUID = 7099057708183571937L;

    /** System time when the event happened */
    private final long timestamp;


    /**
     * Create a new DomainEvent.
     */
    public DomainEvent() {
        this.timestamp = System.currentTimeMillis();
    }


    /**
     * Return the system time in milliseconds when the event happened.
     */
    public final long getTimestamp() {
        return this.timestamp;
    }

}
