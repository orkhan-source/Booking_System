package org.App.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String getTime(LocalDateTime ldt) {
        return ldt.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static String getDate(LocalDateTime ldt)
    {
        return ldt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
