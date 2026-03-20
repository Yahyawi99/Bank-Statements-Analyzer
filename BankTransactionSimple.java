import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.format.*;
import java.time.*;

public class BankTransactionSimple {
  private static final String RESOURCES = "src/main/resources/";

  public static void main(String[] args) throws IOException {
    final Path path = Paths.get(RESOURCES + args[0]);
    final List<String> lines = Files.readAllLines(path);

    // Total expenses
    double total = 0;
    for (String line : lines) {
      final String[] columns = line.split(",");
      total += Double.parseDouble(columns[1]);
    }

    System.out.println("Your total transations is " + total + "$");

    // Total expenses in January
    total = 0;
    final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    for (String line : lines) {
      final String[] columns = line.split(",");
      final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

      if (date.getMonth() == Month.JANUARY) {
        total += Double.parseDouble(columns[1]);
      }
    }
    System.out.println("Your total transations in January is " + total + "$");

  }

}