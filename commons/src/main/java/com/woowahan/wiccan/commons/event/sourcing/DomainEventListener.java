package com.woowahan.wiccan.commons.event.sourcing;

import java.util.EventListener;

/**
 * EventListener for DomainEvent
 * Created by justicehoop on 2017. 4. 4..
 */
public interface DomainEventListener<E extends DomainEvent> extends EventListener {
    void onDomainEvent(E event);
}
