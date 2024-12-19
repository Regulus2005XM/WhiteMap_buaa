package com.whitemap.whitespringboot3.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeUtil {

    public static long time2Seconds(int days, int hours, int minutes, int seconds) {
        long totalSeconds = days * 24 * 60 * 60;
        totalSeconds += hours * 60 * 60;
        totalSeconds += minutes * 60;
        totalSeconds += seconds;
        return totalSeconds;
    }

    public static long getSecondsBetween(Timestamp firstTimestamp, Timestamp secondTimestamp) {
        long firstTimeInMillis = firstTimestamp.getTime();
        long secondTimeInMillis = secondTimestamp.getTime();
        return Math.abs((secondTimeInMillis - firstTimeInMillis) / 1000);
    }

    public static long getSecondsSince(Timestamp timestamp) {
        long currentTimeInMillis = System.currentTimeMillis();
        long timestampTimeInMillis = timestamp.getTime();
        return Math.abs((currentTimeInMillis - timestampTimeInMillis) / 1000);
    }

    public static Timestamp getUnixEpochTimestamp() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(1970, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }
}