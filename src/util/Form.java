package src.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.List;

public class Form {
  private Scanner scanner;

  public Form() {
    this.scanner = new Scanner(System.in);
  }

  public String getString(String title) {
    System.out.print(title + ": ");
    return scanner.nextLine();
  }

  public LocalDateTime getDate(String title) {
    LocalDateTime date = null;
    while (date == null) {
      System.out.print(title + " (yyyy-MM-dd HH:mm): ");
      String input = scanner.nextLine();
      date = DateTimeUtils.getDateTimeFromString(input);
    }
    return date;
  }

  public int getInt(String title) {
    Integer number = null;
    while (number == null) {
      System.out.print(title + ": ");
      String input = scanner.nextLine();
      try {
        number = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Invalid integer. Please try again.");
      }
    }
    return number;
  }

  public int getRadioOption(String title, List<String> options) {
    System.out.println(title + ": ");
    Display display = new Display();
    display.printOptions(options);
    Integer option = null;
    while (option == null) {
      System.out.print("Enter a number between (1-" + options.size() + "): ");
      String input = scanner.nextLine();
      try {
        option = Integer.parseInt(input);
        if (option < 1 || option > options.size()) {
          System.out.println("Option must be between 1 and " + options.size() + ". Please try again.");
          option = null;
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid option. Please try again.");
      }
    }
    return option;
  }
}
