package src.main.java;

import java.time.Month;

public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {
  public boolean test(final BankTransaction bankTransaction) {
    return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
  }
}
