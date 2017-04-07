package com.woowahan.wiccan.commons.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public abstract class DateUtils {

    public static Date getNowDate() {
        return Date.from(LocalDateTime.now(ZoneId.systemDefault()).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime asLocalDateTime(Date selectedDate) {
        Instant instant = selectedDate.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static LocalDateTime plusDays(Date selectedDate, Integer days) {
        Instant instant = selectedDate.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).plusDays(days);
    }

    public static LocalDateTime minusDays(Date selectedDate, Integer days) {
        Instant instant = selectedDate.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).minusDays(days);
    }

    public static Date minusDaysAsDate(Date selectedDate, Integer days) {
        return asDate(minusDays(selectedDate, days));
    }

    public static Date getEndDateOfDay(Date selectedDate) {
        LocalDateTime nextDay = plusDays(selectedDate, 1).toLocalDate().atStartOfDay();
        return asDate(nextDay.minusSeconds(1));
    }

    public static Date getStartDateOfDay(Date selectedDate) {
        Instant instant = selectedDate.toInstant();
        LocalDateTime startOfDay = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate().atStartOfDay();
        return asDate(startOfDay);
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date plusDaysAsDate(Date selectedDate, Integer days) {
        return asDate(plusDays(selectedDate, days));
    }

    //yyyy-MM-dd HH:mm
    public static String asString(Date selectedDate, String format) {
        Instant instant = selectedDate.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String asString(Date selectedDate) {
        Instant instant = selectedDate.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_FORMAT);
        return localDateTime.format(formatter);
    }

    public static final String BUSINESS_DAY_FORMAT = "yyyyMMdd";

    public static String asStringToBusinessDay(Date selectedDate) {
        Instant instant = selectedDate.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(BUSINESS_DAY_FORMAT);
        return localDateTime.format(formatter);
    }

    public static Date plusMinutes(Date selectedDate, Integer min) {
        Instant instant = selectedDate.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).plusMinutes(min);
        return DateUtils.asDate(localDateTime);
    }

    public static Long betweenMin(Date fromDate, Date toDate) {
        LocalDateTime fromLocalDateTime = asLocalDateTime(fromDate);
        LocalDateTime toLocalDateTime = asLocalDateTime(toDate);
        return ChronoUnit.MINUTES.between(fromLocalDateTime, toLocalDateTime);
    }

    public static Date minusMin(Date selectedDate, Integer min) {
        LocalDateTime date = asLocalDateTime(selectedDate);
        return asDate(date.minusMinutes(min));
    }

    public static Date convertStringToDate(String dateString, String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return asDate(dateTime);
    }

    /**
     * yyyy-MM-dd HH:mm:ss.SSS 형태로 변한할 경우 SimpleDateFormat으로 변환해서 사용합니다.
     *
     * @param dateString
     * @param dateFormat
     * @return
     */
    public static Date convertStringToDateBySimpleDateTime(String dateString, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        try {
            return simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }
}
