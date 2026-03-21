import java.time.*;
import java.time.format.*;
import java.util.*;

public class BankStatmentCSVParser implements BankStatmentParser {
  private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  public BankTransaction parseFrom(final String line) {
    final String[] columns = line.split(",");

    final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
    final double amount = Double.parseDouble(columns[1]);
    final String desc = columns[2];

    return new BankTransaction(date, amount, desc);
  }

  public List<BankTransaction> parseLinesFrom(final List<String> lines) {
    final List<BankTransaction> bankTransactions = new ArrayList<>();

    for (final String line : lines) {
      bankTransactions.add(parseFrom(line));
    }

    return bankTransactions;
  }
}
