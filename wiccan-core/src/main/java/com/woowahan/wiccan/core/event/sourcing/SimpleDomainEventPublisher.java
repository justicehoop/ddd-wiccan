package com.woowahan.wiccan.core.event.sourcing;

import org.apache.commons.logging.LogFactory;
import org.springframework.core.ResolvableType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
public class SimpleDomainEventPublisher implements DomainEventPublisher {

    private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
        protected DomainEventPublisher initialValue() {
            return new SimpleDomainEventPublisher();
        }
    };

    private List<DomainEventListener<? extends DomainEvent>> listeners = new ArrayList<>();


    @Override
    public void addApplicationListener(DomainEventListener<? extends DomainEvent> listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeApplicationListener(DomainEventListener<? extends DomainEvent> listener) {
        this.listeners.remove(listener);
    }

    @Override
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
    public DomainEventPublisher instance() {
        return instance.get();
    }

    @Override
    public void publishEvent(DomainEvent event) {
        multicastEvent(event);
    }
}
