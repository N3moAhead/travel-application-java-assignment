package src.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
  private CSVReader() {}

  public static List<String[]> getRecordsFromFile(String filePath) {
    List<String[]> records = new ArrayList<>();
    try (Scanner scanner  = new Scanner(new File(filePath))) {
      while (scanner.hasNextLine()) {
        records.add(scanner.nextLine().split(","));
      }
    } catch (FileNotFoundException e) {
      System.out.println("The given File could not be found :/");
    }
    return records;
  }
}
