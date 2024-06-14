package src.util;

import java.util.List;

public class Display {
  public void printHeading(String heading) {
    int width = 50;
    int padding = (width - heading.length()) / 2;
    System.out.println("\n\n");
    System.out.println("**************************************************");
    System.out.print("*");
    for (int i = 0; i < width - 2; i++) {
      System.out.print(" ");
    }
    System.out.println("*");
    System.out.print("*");
    for (int i = 0; i < padding - 1; i++) {
      System.out.print(" ");
    }
    System.out.print(heading);
    for (int i = 0; i < width - padding - heading.length() - 1; i++) {
      System.out.print(" ");
    }
    System.out.println("*");
    System.out.print("*");
    for (int i = 0; i < width - 2; i++) {
      System.out.print(" ");
    }
    System.out.println("*");
    System.out.println("**************************************************\n");
  }

  public void printSubHeading(String subHeading) {
    int width = 50;
    int padding = (width - subHeading.length()) / 2;
    System.out.println("\n");
    for (int i = 0; i < padding - 1; i++) {
      System.out.print("-");
    }
    System.out.print(subHeading);
    for (int i = 0; i < padding - 1; i++) {
      System.out.print("-");
    }
    System.out.println("\n");
  }

  public void printOptions(List<String> options) {
    for (int i = 0; i < options.size(); i++) {
      System.out.println("(" + (i + 1) + ") " + options.get(i));
    }
  }
}