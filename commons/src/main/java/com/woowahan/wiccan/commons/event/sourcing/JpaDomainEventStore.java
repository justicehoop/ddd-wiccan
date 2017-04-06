package com.woowahan.wiccan.commons.event.sourcing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woowahan.wiccan.commons.entity.DomainEventHistory;
import com.woowahan.wiccan.commons.repository.DomainEventHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@Service
public class JpaDomainEventStore implements DomainEventStore<String> {
    @Autowired
    private DomainEventHistoryRepository domainEventHistoryRepository;
    @Autowired
    private ObjectMapper objectMapper;
    private DomainEventAdapter domainEventAdapter;

    @PostConstruct
    public void afterInitialized() {
        this.domainEventAdapter = new DomainEventAdapter(objectMapper);
    }

    @Override
    public String save(DomainEvent event) {
        DomainEventHistory eventHistory = domainEventHistoryRepository.save(domainEventAdapter.adapt(event));
        return eventHistory.getEventContent();
    }

    @Override
    public String findOne(String eventId) {
        DomainEventHistory history = domainEventHistoryRepository.findOne(eventId);
        return history.getEventContent();
    }

    @Override
    public void delete(String eventId) {
        domainEventHistoryRepository.delete(eventId);
    }

    @Override
    public void deleteAll() {
        domainEventHistoryRepository.deleteAll();
    }

    public static final class DomainEventAdapter {
        private ObjectMapper objectMapper;

        DomainEventAdapter(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }


        public final DomainEventHistory adapt(DomainEvent domainEvent) {
            try {
                String eventContent = objectMapper.writeValueAsString(domainEvent);
                return DomainEventHistory.of(domainEvent.getEventId(), eventContent);
            } catch (JsonProcessingException e) {
                throw new FailedToEventContentException("Failed to convert event object to content", e);
            }
        }

        public static class FailedToEventContentException extends RuntimeException {

            public FailedToEventContentException(String msg, Throwable t) {
                super(msg, t);
            }
        }
    }
}
