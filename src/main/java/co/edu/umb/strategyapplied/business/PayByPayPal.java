package co.edu.umb.strategyapplied.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements PayPal payment method.
 */
public class PayByPayPal implements PayStrategy{

  private static final Map<String, String> DATA_BASE = new HashMap<>();
  private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private String email;
  private String password;
  private boolean signedIn;

  static {
    DATA_BASE.put("amanda1985", "amanda@ya.com");
    DATA_BASE.put("qwerty", "john@amazon.eu");
  }

  /**
   * Save customer data for future shopping attempts.
   */
  @Override
  public boolean pay(int paymentAmount) {
    if (signedIn){
      System.out.println("Paying "+paymentAmount+" using Paypal.");
      return true;
    }
    return false;
  }

  private boolean verify() {
    setSignedIn(email.equals(DATA_BASE.get(password)));
    return signedIn;
  }

  /**
   * Collect customer's data.
   */
  @Override
  public void collectPaymentDetails() {
    try {
      while (!signedIn){
        System.out.println("Enter the user's email: ");
        email = reader.readLine();
        System.out.println("Enter the password: ");
        password = reader.readLine();
        if (verify()){
          System.out.println("Data verification has been successful");;
        } else {
          System.out.println("Wrong email or password");
        }
      }
    } catch (IOException e){
      e.printStackTrace(System.err);
    }
  }

  private void setSignedIn(boolean signedIn) {
    this.signedIn = signedIn;
  }
}
