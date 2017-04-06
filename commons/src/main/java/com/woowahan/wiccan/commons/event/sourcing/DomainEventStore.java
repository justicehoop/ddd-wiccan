package com.woowahan.wiccan.commons.event.sourcing;

/**
 * DomainEvent를 저장할 Storage
 * Created by justicehoop on 2017. 4. 6..
 */
public interface DomainEventStore<T> {

    T save(DomainEvent event);

    T findOne(String eventId);

    void delete(String eventId);

    void deleteAll();
}
