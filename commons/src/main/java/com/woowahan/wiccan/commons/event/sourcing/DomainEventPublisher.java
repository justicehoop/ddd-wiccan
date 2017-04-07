package com.woowahan.wiccan.commons.event.sourcing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * DomainEvent publisher
 * listener를 등록하고 EventType에 매칭되는 listener를 호출한다
 * Created by justicehoop on 2017. 4. 4..
 */
@Slf4j
public class DomainEventPublisher {

    private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
        protected DomainEventPublisher initialValue() {
            return new DomainEventPublisher();
        }
    };

    private static final List<DomainEventListener<? extends DomainEvent>> listeners = new CopyOnWriteArrayList<>();

    public void addEventListener(DomainEventListener<? extends DomainEvent> listener) {
        this.listeners.add(listener);
    }

    public void removeEventListener(DomainEventListener<? extends DomainEvent> listener) {
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

        log.debug("resolvableType:{}" , type);
        for (final DomainEventListener<?> listener : listeners) {
            if(isMatchedListener(listener, type)) {
                invokeListener(listener, event);
            }

        }
    }

    private boolean isMatchedListener(final DomainEventListener<?> listener, ResolvableType type) {
        Class<?> listenerType = GenericTypeResolver.resolveTypeArgument(listener.getClass(), DomainEventListener.class);
        log.debug("genericSuperClass:{}, matched:{}", listenerType.getName(),listenerType.isAssignableFrom(type.getRawClass()));

        return listenerType.isAssignableFrom(type.getRawClass());
    }

    private void invokeListener(DomainEventListener listener, DomainEvent event) {
        try {
            listener.onDomainEvent(event);
        }
        catch (ClassCastException ex) {
            log.error("Non-matching event type for listener: {}" ,listener, ex);
            throw new DomainEventMulticastFailedException("Non-matching event type for listener", ex);
        }
    }
    public static DomainEventPublisher instance() {
        return instance.get();
    }

    public void publishEvent(DomainEvent event) {
        multicastEvent(event);
    }
}
