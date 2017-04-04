package com.woowahan.wiccan.core.event.sourcing;

import java.util.EventListener;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
public interface DomainEventListener<E extends DomainEvent> extends EventListener {
    void onDomainEvent(E event);
}
