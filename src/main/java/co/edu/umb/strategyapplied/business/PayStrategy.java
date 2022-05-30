package co.edu.umb.strategyapplied.business;

/**
 * Common interface for all strategies.
 */
public interface PayStrategy {

  boolean pay(int paymentAmount);
  void collectPaymentDetails();

}
