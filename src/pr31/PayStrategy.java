package pr31;


public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();

}