package com.woowahan.wiccan.core.event.sourcing;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
public interface DomainEventPublisher {

    void addApplicationListener(DomainEventListener<?> listener);

    void removeApplicationListener(DomainEventListener<?> listener);

    void removeAllListeners();

    void publishEvent(DomainEvent event);

}
