package com.woowahan.wiccan.management.ports.externals.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woowahan.wiccan.management.ports.externals.model.AdExportModel;
import com.woowahan.wiccan.management.ports.externals.service.AdImpressionSyncService;
import com.woowahan.wiccan.management.ports.externals.service.dto.AdSyncCommand;
import com.woowahan.wiccan.messaging.AmqpOperations;
import com.woowahan.wiccan.messaging.RabbitTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@Slf4j
@Service
public class AdImpressionSyncServiceImpl implements AdImpressionSyncService {

    private AmqpOperations amqpOperations = new RabbitTemplate();
    @Autowired
    private ObjectMapper objectMapper;

    public void setAmqpOperations(AmqpOperations amqpOperations) {
        this.amqpOperations = amqpOperations;
    }

    @Override
    public void sync(AdExportModel ad) {
        log.info("[SYNCAD] export ad's information to impression service");
        amqpOperations.convertAndSend(ad);
    }
    private String convert(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new AdImpressionSyncFailedException("Failed to jsonProcessing to write as string", e);
        }
    }

    @Override
    public void syncStatus(AdSyncCommand command) {
        amqpOperations.convertAndSend(command);
    }




}
