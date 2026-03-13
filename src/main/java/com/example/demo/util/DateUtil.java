package com.example.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String toString(LocalDate date) {
        return (date != null) ? date.format(FORMATTER) : null;
    }

    public static LocalDate toDate(String dateString) {
        return (dateString != null) ? LocalDate.parse(dateString, FORMATTER) : null;
    }
}
