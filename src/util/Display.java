package src.util;

import java.util.List;

/**
 * Provides Functions to print formatted text to the terminal 
 */
public class Display {
  /**
   * Private constructor to prevent instantiation of the utility class.
   */
  private Display() {}

  /**
   * Prints a heading centered within a box of asterisks.
   * The heading is centered within a width of 50 characters.
   *
   * @param heading The heading text to be printed.
   */
  public static void printHeading(String heading) {
    int width = 50;
    int padding = (width - heading.length()) / 2;
    System.out.println("\n\n");
    System.out.println("**************************************************");
    System.out.print("*");
    
    // Print top padding line
    for (int i = 0; i < width - 2; i++) {
      System.out.print(" ");
    }
    System.out.println("*");
    
    // Print heading with padding
    System.out.print("*");
    for (int i = 0; i < padding - 1; i++) {
      System.out.print(" ");
    }
    System.out.print(heading);
    for (int i = 0; i < width - padding - heading.length() - 1; i++) {
      System.out.print(" ");
    }
    System.out.println("*");
    
    // Print bottom padding line
    System.out.print("*");
    for (int i = 0; i < width - 2; i++) {
      System.out.print(" ");
    }
    System.out.println("*");
    System.out.println("**************************************************\n");
  }

  /**
   * Prints a subheading centered within a line of hyphens.
   * The subheading is centered within a width of 50 characters.
   *
   * @param subHeading The subheading text to be printed.
   */
  public static void printSubHeading(String subHeading) {
    int width = 50;
    int padding = (width - subHeading.length()) / 2;
    System.out.println("\n");
    
    // Print left hyphen line
    for (int i = 0; i < padding - 1; i++) {
      System.out.print("-");
    }

    // Print the heading in the middle
    System.out.print(subHeading);
    
    // Print right hyphen line
    for (int i = 0; i < padding - 1; i++) {
      System.out.print("-");
    }
    System.out.println("\n");
  }

  /**
   * Prints a list of options, each prefixed with a number in parentheses.
   * Each option is printed on a new line.
   *
   * @param options The list of options to be printed.
   */
  public static void printOptions(List<String> options) {
    for (int i = 0; i < options.size(); i++) {
      System.out.println("(" + (i + 1) + ") " + options.get(i));
    }
  }
}
