package com.woowahan.wiccan.management.ports.externals.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woowahan.wiccan.management.ports.externals.model.ListingAdSyncCommand;
import com.woowahan.wiccan.management.ports.externals.service.AdChangedNotifyService;
import com.woowahan.wiccan.management.ports.externals.service.dto.AdStatusNotifyCommand;
import com.woowahan.wiccan.messaging.AmqpOperations;
import com.woowahan.wiccan.messaging.RabbitTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by justicehoop on 2017. 4. 7..
 */
@Slf4j
@Service
public class AdChangedNotifyServiceImpl implements AdChangedNotifyService {

    private AmqpOperations amqpOperations = new RabbitTemplate();
    @Autowired
    private ObjectMapper objectMapper;

    public void setAmqpOperations(AmqpOperations amqpOperations) {
        this.amqpOperations = amqpOperations;
    }

    @Override
    public void notifyAdCreated(ListingAdSyncCommand ad) {
        log.info("[notifyAdCreated] export ad's information to impression service");
        amqpOperations.convertAndSend(ad);
    }

    private String convert(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new AdChangedNotifyFailedException("Failed to jsonProcessing to write as string", e);
        }
    }

    @Override
    public void notifyAdStatusChanged(AdStatusNotifyCommand command) {
        amqpOperations.convertAndSend(command);
    }
}
