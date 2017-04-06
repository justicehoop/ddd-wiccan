package com.woowahan.wiccan.commons.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public abstract class DateUtils {
    public static LocalDateTime asLocalDateTime(Date selectedDate) {
        Instant instant = selectedDate.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

}
