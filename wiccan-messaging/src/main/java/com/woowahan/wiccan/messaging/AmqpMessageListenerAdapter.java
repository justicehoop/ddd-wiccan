package com.woowahan.wiccan.messaging;

/**
 * Created by justicehoop on 2017. 4. 14..
 */
public class AmqpMessageListenerAdapter implements MessageListener{

    private MessageListener delegate;


    @Override
    public void onMessage(Object message) {
        delegate.onMessage(message);
    }
}
