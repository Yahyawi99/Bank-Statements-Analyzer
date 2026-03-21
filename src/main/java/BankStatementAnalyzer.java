package src.main.java;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;

public class BankStatementAnalyzer {
  private static final String RESOURCES = "src/main/resources/";

  public void analyze(final String fileName, final BankStatmentParser bankStatmentParser) throws IOException {
    final Path path = Paths.get(RESOURCES + fileName);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatmentParser.parseLinesFrom(lines);

    final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

    System.out.println("Total Transactions is " + bankStatementProcessor.calculateTotalAmount());
    System.out.println(
        "Total Transactions in January is " + bankStatementProcessor.calculateTotalAmountInMonth(Month.JANUARY));

  }
}
