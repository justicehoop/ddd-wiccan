package com.woowahan.wiccan.commons.event.sourcing;

import java.util.UUID;

/**
 * 도메인 Event 객체 / DomainEventPublisher로 publish할 이벤트는 DomainEvent를 상속 받아야 함
 * Created by justicehoop on 2017. 4. 4..
 */
public abstract class DomainEvent {

    /** use serialVersionUID from Spring 1.2 for interoperability */
    private static final long serialVersionUID = 7099057708183571937L;
    /** System time when the event happened */
    protected final long timestamp;
    /** eventId for unique identity **/
    protected String eventId;
    protected Object source;


    /**
     * Create a new DomainEvent.
     */
    public DomainEvent(Object source) {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
        this.source = source;
    }


    /**
     * Return the system time in milliseconds when the event happened.
     */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getEventId() {
        return this.eventId;
    }

}
