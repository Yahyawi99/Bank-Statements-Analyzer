
import java.util.*;
import java.time.*;

public class BankStatementProcessor {
  private final List<BankTransaction> bankTransactions;

  public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
    this.bankTransactions = bankTransactions;
  }

  public double calculateTotalAmount() {
    double total = 0;

    for (BankTransaction bankTransaction : bankTransactions) {
      total += bankTransaction.getAmount();
    }

    return total;
  }

  public double calculateTotalAmountInMonth(final Month month) {
    double total = 0;

    for (BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDate().getMonth() == month)
        total += bankTransaction.getAmount();
    }

    return total;
  }
}
