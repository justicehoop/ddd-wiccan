package com.woowahan.wiccan.commons.event.sourcing;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
public abstract class TestableDomainEventListener<T extends DomainEvent> extends CallCountableSupport implements DomainEventListener<T> {
        @Override
        public void onDomainEvent(T event) {
            onDomainEventInternal(event);
            increment();
        }

    public abstract void onDomainEventInternal(T event);
}
