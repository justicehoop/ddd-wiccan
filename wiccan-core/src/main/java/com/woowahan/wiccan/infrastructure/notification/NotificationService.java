package com.woowahan.wiccan.infrastructure.notification;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
public interface NotificationService {
    void send(String from, String to, String content);
}
