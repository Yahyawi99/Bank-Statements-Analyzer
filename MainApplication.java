import java.io.IOException;

public class MainApplication {
  public static void main(String[] args) throws IOException {
    final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

    final BankStatmentParser BankStatmentParser = new BankStatmentCSVParser();

    bankStatementAnalyzer.analyze(args[0], BankStatmentParser);
  }
}
