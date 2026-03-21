package src.main.java;

import java.util.List;

public interface BankStatmentParser {
  BankTransaction parseFrom(String line);

  List<BankTransaction> parseLinesFrom(List<String> lines);
}
