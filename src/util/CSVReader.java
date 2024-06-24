package src.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The CSVReader class provides utility methods for reading CSV files.
 * It contains a static method to read records from a CSV file and
 * return them as a list of string arrays.
 */
public class CSVReader {

  /**
   * Private constructor to prevent instantiation of the utility class.
   */
  private CSVReader() {}

  /**
   * Reads records from a CSV file and returns them as a list of string arrays.
   * Each array represents a line from the CSV file, split by commas.
   * 
   * @param filePath the path to the CSV file to be read
   * @return a list of string arrays, where each array represents a line from the CSV file
   */
  public static List<String[]> getRecordsFromFile(String filePath) {
    List<String[]> records = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(filePath))) {
      // Read each line from the file and split it by commas
      while (scanner.hasNextLine()) {
        records.add(scanner.nextLine().split(","));
      }
    } catch (FileNotFoundException e) {
      // Handle the case where the file is not found
      System.out.println("The given file could not be found :/");
    }
    return records;
  }
}
