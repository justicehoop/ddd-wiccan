package com.woowahan.wiccan.messaging;

/**
 * Created by justicehoop on 2017. 4. 14..
 */
public class SimpleMessageContainer implements MessageContainer {

    private MessageListener messageListener;

    public void setMessageListener(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    @Override
    public void start() {

    }
}