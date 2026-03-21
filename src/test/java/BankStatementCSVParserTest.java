package src.test.java;

import java.time.LocalDate;
import java.time.Month;

import org.junit.*;

import src.main.java.BankStatmentCSVParser;
import src.main.java.BankStatmentParser;
import src.main.java.BankTransaction;

public class BankStatementCSVParserTest {
  private final BankStatmentParser statmentParser = new BankStatmentCSVParser();

  @Test
  public void shouldParseOneCorrectLine() throws Exception {
    final String line = "30-01-2017,-100,Deliveroo";

    final BankTransaction result = statmentParser.parseFrom(line);

    final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo");

    final double tolerance = 0.0d;

    Assert.assertEquals(expected.getDate(), result.getDate());
    Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
    Assert.assertEquals(expected.getDesc(), result.getDesc());
  }
}
