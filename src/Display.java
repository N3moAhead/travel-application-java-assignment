package src;

public class Display {
  public void printHeading(String heading) {
    int width = 50;
    int padding = (width - heading.length()) / 2;
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
    System.out.println("**************************************************");
  }
}
