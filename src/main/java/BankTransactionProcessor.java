package src.main.java;

import java.util.*;
import java.time.*;

public class BankTransactionProcessor {
  private final List<BankTransaction> bankTransactions;

  public BankTransactionProcessor(final List<BankTransaction> bankTransactions) {
    this.bankTransactions = bankTransactions;
  }

  // used summarize
  public double summarizeTransaction(BankTransactionSummarizer bankTransactionSummarizer) {
    double total = 0;

    for (BankTransaction bankTransaction : bankTransactions) {
      total = bankTransactionSummarizer.summarize(total, bankTransaction);
    }

    return total;
  }

  public double calculateTotalAmount() {
    return summarizeTransaction((double acc, BankTransaction bankTransaction) -> acc + bankTransaction.getAmount());
  }

  public double calculateTotalAmountInMonth(Month month) {
    return summarizeTransaction((double acc, BankTransaction bankTransaction) -> bankTransaction.getDate()
        .getMonth() == month ? acc + bankTransaction.getAmount() : acc);
  }

  // used test()
  public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
    final List<BankTransaction> result = new ArrayList<>();

    for (BankTransaction bankTransaction : bankTransactions) {
      if (bankTransactionFilter.test(bankTransaction))
        result.add(bankTransaction);
    }

    return result;
  }

  public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
    return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
  };
}
