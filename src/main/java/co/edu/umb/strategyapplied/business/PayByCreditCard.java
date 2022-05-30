package co.edu.umb.strategyapplied.business;

import co.edu.umb.strategyapplied.entities.CreditCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy {

  private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private CreditCard card;

  /**
   * After card validation we can charge customer's credit card.
   */
  @Override
  public boolean pay(int paymentAmount) {
    if (cardIsPresent()) {
      System.out.println("Paying " + paymentAmount + " using Credit Card.");
      card.setAmount(card.getAmount() - paymentAmount);
      return true;
    }
    return false;
  }

  /**
   * Collect credit card data.
   */
  @Override
  public void collectPaymentDetails() {
    try {
      System.out.print("Enter the card number: ");
      String number = reader.readLine();
      System.out.print("Enter the card expiration date 'mm/yy': ");
      String date = reader.readLine();
      System.out.print("Enter the CVV code: ");
      String cvv = reader.readLine();
      card = new CreditCard(number, date, cvv);

      // Validate credit card number...

    } catch (IOException ex) {
      ex.printStackTrace(System.err);
    }
  }

  private boolean cardIsPresent() {
    return card != null;
  }
}
