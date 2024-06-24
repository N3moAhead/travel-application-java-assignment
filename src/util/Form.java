package src.util;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.List;

/**
 * Provides to functions to handle user input correctly
 */
public class Form {
  private Scanner scanner;

  public Form() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Read a string from the terminal
   * @param title a title that will be displayed next to the input field
   * @return the String that has been written to the terminal
   */
  public String getString(String title) {
    System.out.print(title + ": ");
    return scanner.nextLine();
  }

  /**
   * Read a date from the terminal
   * 
   * This Function will first read a date from the terminal, will
   * try to parse it to a LocalDateTime and return it afterwards. 
   * @param title a title that will be displayed next to the input field 
   * @return a LocalDateTime Object
   */
  public LocalDateTime getDate(String title) {
    LocalDateTime date = null;
    // Repeat until the user provided a correctly formatted date
    while (date == null) {
      System.out.print(title + " (yyyy-MM-dd HH:mm): ");
      String input = scanner.nextLine();
      date = DateTimeUtils.getDateTimeFromString(input);
    }
    return date;
  }

  /**
   * Read an integer from the terminal
   * 
   * This function will read a number from the terminal and afterwards
   * will try to parse it to an integer.
   * @param title a title that will be displayed next to the input field 
   * @return a integer
   */
  public int getInt(String title) {
    Integer number = null;
    // Repeat until the user provided a correctly formatted number
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

  /**
   * Display options to the terminal and return
   * a decision made by the user for a single option
   * 
   * @param title a title that will be displayed above the options
   * @param options a list of strings with options the user should choose from
   * @return the decision the user made. The first
   * option in the list will be represented as 1
   */
  public int getRadioOption(String title, List<String> options) {
    System.out.println(title + ": ");
    Display.printOptions(options);
    Integer option = null;
    // Repeat until the user provided a correct number that is also in the provided range
    while (option == null) {
      System.out.print("Enter a number between (1-" + options.size() + "): ");
      String input = scanner.nextLine();
      try {
        // Test if its possible to parse the given string to an integer
        option = Integer.parseInt(input);
        // Check if the provided number is in the correct range
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
