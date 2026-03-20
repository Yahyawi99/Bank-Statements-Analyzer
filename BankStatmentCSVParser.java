import java.time.*;
import java.time.format.*;
import java.util.*;

public class BankStatmentCSVParser {
  private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  private BankTransaction parseFromCSV(final String line) {
    final String[] columns = line.split(",");

    final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
    final double amount = Double.parseDouble(columns[1]);
    final String desc = columns[2];

    return new BankTransaction(date, amount, desc);
  }

  public List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
    final List<BankTransaction> bankTransactions = new ArrayList<>();

    for (final String line : lines) {
      bankTransactions.add(parseFromCSV(line));
    }

    return bankTransactions;
  }
}
