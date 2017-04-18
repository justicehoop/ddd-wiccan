package com.woowahan.wiccan.messaging;

/**
 * Created by justicehoop on 2017. 4. 14..
 */
public interface AmqpOperations {

    void convertAndSend(Object message);
}