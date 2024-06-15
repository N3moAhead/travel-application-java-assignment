package src.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeUtils {
    private DateTimeUtils() {}
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String formatDateTime(LocalDateTime dateTime) {
      return dateTime.format(formatter);
    }

    public static LocalDateTime getDateTimeFromString(String dateString) {
      LocalDateTime date = null;
      try {
        date = LocalDateTime.parse(dateString, formatter);
      } catch (DateTimeParseException e) {
        System.out.println("Invalid date format. Please try again.");
      }
      return date;
    }
}
