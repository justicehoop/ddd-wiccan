package com.woowahan.wiccan.commons.event.sourcing;

import org.apache.commons.logging.LogFactory;
import org.springframework.core.ResolvableType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
public class DomainEventPublisher {

    private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
        protected DomainEventPublisher initialValue() {
            return new DomainEventPublisher();
        }
    };

    private List<DomainEventListener<? extends DomainEvent>> listeners = new ArrayList<>();

    public void addEventListener(DomainEventListener<? extends DomainEvent> listener) {
        this.listeners.add(listener);
    }

    public void removeApplicationListener(DomainEventListener<? extends DomainEvent> listener) {
        this.listeners.remove(listener);
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    private ResolvableType resolveDefaultEventType(DomainEvent event) {
        return ResolvableType.forInstance(event);
    }

    private void multicastEvent(DomainEvent event) {
        multicastEvent(event, resolveDefaultEventType(event));
    }


    private void multicastEvent(final DomainEvent event, ResolvableType eventType) {
        ResolvableType type = (eventType != null ? eventType : resolveDefaultEventType(event));

        for (final DomainEventListener<?> listener : listeners) {
            invokeListener(listener, event);
        }
    }

    private void invokeListener(DomainEventListener listener, DomainEvent event) {
        try {
            listener.onDomainEvent(event);
        }
        catch (ClassCastException ex) {
            LogFactory.getLog(getClass()).debug("Non-matching event type for listener: " + listener, ex);
        }
    }
    public static DomainEventPublisher instance() {
        return instance.get();
    }

    public void publishEvent(DomainEvent event) {
        multicastEvent(event);
    }
}
