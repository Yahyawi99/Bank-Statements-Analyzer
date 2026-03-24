package src.main.java;

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

  public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
    final List<BankTransaction> result = new ArrayList<>();

    for (BankTransaction bankTransaction : bankTransactions) {
      if (bankTransactionFilter.test(bankTransaction))
        result.add(bankTransaction);
    }

    return result;
  }
}
