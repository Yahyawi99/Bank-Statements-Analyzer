import java.util.List;

interface BankStatmentParser {
  BankTransaction parseFrom(String line);

  List<BankTransaction> parseLinesFrom(List<String> lines);
}
