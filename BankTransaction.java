import java.time.*;
import java.util.Objects;

public class BankTransaction {
  private final LocalDate date;
  private final double amount;
  private final String desc;

  BankTransaction(final LocalDate date, final double amount, final String desc) {
    this.date = date;
    this.amount = amount;
    this.desc = desc;
  }

  public LocalDate getDate() {
    return date;
  }

  public double getAmount() {
    return amount;
  }

  public String getDesc() {
    return desc;
  }

  @Override
  public String toString() {
    return "BankTransaction{" +
        "date=" + date +
        ", amount=" + amount +
        ", description='" + desc + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    BankTransaction that = (BankTransaction) o;

    return Double.compare(amount, that.amount) == 0 && date.equals(that.date) && desc.equals(that.desc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, amount, desc);
  }
}
