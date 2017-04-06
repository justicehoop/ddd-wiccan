package com.woowahan.wiccan.commons.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@Entity
@Getter
public class DomainEventHistory extends BaseEntity {
    @Id
    private String eventId;
    private String eventContent;
    @Temporal(TemporalType.TIMESTAMP)
    private Date occurredAt = new Date();

    DomainEventHistory() {}

    public static DomainEventHistory of(String eventId, String eventContent) {
        DomainEventHistory instance = new DomainEventHistory();
        instance.eventId = eventId;
        instance.eventContent = eventContent;
        return instance;
    }

}
