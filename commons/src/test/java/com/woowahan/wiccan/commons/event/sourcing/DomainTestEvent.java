package com.woowahan.wiccan.commons.event.sourcing;

import lombok.ToString;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@ToString
public class DomainTestEvent extends DomainEvent {

    /**
     * Create a new DomainEvent.
     *
     * @param source
     */
    public DomainTestEvent(Object source) {
        super(source);
    }
}
