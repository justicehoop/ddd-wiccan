package com.woowahan.wiccan.commons.event.sourcing;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@Slf4j
public class FileLogDomainEventStore implements DomainEventStore<DomainEvent> {
    @Override
    public DomainEvent save(DomainEvent event) {
        log.info("{}", event);
        return event;
    }

    @Override
    public DomainEvent findOne(String eventId) {
        throw new UnsupportedOperationException("findOne does not support!");
    }

    @Override
    public void delete(String eventId) {
        throw new UnsupportedOperationException("delete does not support!");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("deleteAll does not support!");
    }
}
