interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String expiryDate;
    private int cvv;

    public CreditCardPayment(String cardNumber, String name, String expiryDate, int cvv) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class CarStore {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void purchaseCar(int carPrice) {
        System.out.println("Car purchased for $" + carPrice);

        if (paymentStrategy != null) {
            paymentStrategy.pay(carPrice);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CarStore carStore = new CarStore();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "John Doe", "12/24", 123);
        carStore.setPaymentStrategy(creditCardPayment);
        carStore.purchaseCar(25000);

        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        carStore.setPaymentStrategy(payPalPayment);
        carStore.purchaseCar(30000);
    }
}