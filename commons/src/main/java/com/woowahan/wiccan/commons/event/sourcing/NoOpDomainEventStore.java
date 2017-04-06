package com.woowahan.wiccan.commons.event.sourcing;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
public class NoOpDomainEventStore implements DomainEventStore<DomainEvent> {
    @Override
    public DomainEvent save(DomainEvent event) {
        return null;
    }

    @Override
    public DomainEvent findOne(String eventId) {
        return null;
    }

    @Override
    public void delete(String eventId) {

    }

    @Override
    public void deleteAll() {

    }
}
