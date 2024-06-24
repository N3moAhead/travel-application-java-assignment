package src.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utility Functions to work with dates.
 */
public class DateTimeUtils {
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  
  /**
   * Private constructor to prevent instantiation of the utility class.
   */
  private DateTimeUtils() {}

  /**
   * Parses a LocalDateTime Object to a formatted String.
   * 
   * @param dateTime LocalDateTime object that should be parsed to a string.
   * @return the provided date as a string in the correct format.
   */
  public static String formatDateTime(LocalDateTime dateTime) {
    return dateTime.format(formatter);
  }

  /**
   * Create a LocalDateTime Object from a string.
   * 
   * @param dateString the date string that should be parsed.
   * @return null or LocalDateTime
   */
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
