package src.main.java;

import java.io.IOException;
import java.util.List;

public class MainApplication {
  public static void main(String[] args) throws IOException {
    final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

    final BankStatmentParser BankStatmentParser = new BankStatmentCSVParser();

    bankStatementAnalyzer.analyze(args[0], BankStatmentParser);

  }
}
