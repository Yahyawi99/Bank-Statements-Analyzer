import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;

public class BankStatementAnalyzer {
  private static final String RESOURCES = "src/main/resources/";
  private final static BankStatmentCSVParser bankStatmentCSVParser = new BankStatmentCSVParser();

  public static void main(final String args[]) throws IOException {
    final String fileName = args[0];
    final Path path = Paths.get(RESOURCES + fileName);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatmentCSVParser.parseLinesFromCSV(lines);
    final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

    System.out.println("Total Transactions is " + bankStatementProcessor.calculateTotalAmount());
    System.out.println(
        "Total Transactions in January is " + bankStatementProcessor.calculateTotalAmountInMonth(Month.JANUARY));
  }

}
