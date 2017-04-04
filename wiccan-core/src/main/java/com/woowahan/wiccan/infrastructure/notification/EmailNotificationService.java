package com.woowahan.wiccan.infrastructure.notification;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
@Slf4j
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String from, String to, String content) {
        log.info("email send => from:{}, to:{}, content:{}", from, to, content);
    }
}
