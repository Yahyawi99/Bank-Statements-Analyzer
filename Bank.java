import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.*;

public class Bank {
  private static final String RESOURCES = "src/main/resources/";

  public static void main(final String args[]) throws IOException {
    final BankStatmentCSVParser bankStatmentCSVParser = new BankStatmentCSVParser();

    final String fileName = args[0];
    final Path path = Paths.get(RESOURCES + fileName);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatmentCSVParser.parseLinesFromCSV(lines);

    System.out.println("Total Transactions is " + calculateTotalAmount(bankTransactions));
  }

  public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
    double total = 0;

    for (BankTransaction bankTransaction : bankTransactions) {
      total += bankTransaction.getAmount();
    }

    return total;
  }

  public static double calculateTotalAmountInMonth(final List<BankTransaction> bankTransactions, final Month month) {
    double total = 0;

    for (BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDate().getMonth() == month)
        total += bankTransaction.getAmount();
    }

    return total;
  }
}
