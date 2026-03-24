package src.main.java;

@FunctionalInterface
interface BankTransactionSummarizer {
  double summarize(double prev, BankTransaction bankTransaction);
}
