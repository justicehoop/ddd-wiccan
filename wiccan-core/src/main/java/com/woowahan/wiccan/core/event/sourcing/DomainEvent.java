package com.woowahan.wiccan.core.event.sourcing;

import java.util.EventObject;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
public abstract class DomainEvent extends EventObject {

    /** use serialVersionUID from Spring 1.2 for interoperability */
    private static final long serialVersionUID = 7099057708183571937L;

    /** System time when the event happened */
    private final long timestamp;


    /**
     * Create a new ApplicationEvent.
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DomainEvent(Object source) {
        super(source);
        this.timestamp = System.currentTimeMillis();
    }


    /**
     * Return the system time in milliseconds when the event happened.
     */
    public final long getTimestamp() {
        return this.timestamp;
    }

}
