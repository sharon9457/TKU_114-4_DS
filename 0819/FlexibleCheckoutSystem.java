interface PricingPolicy {
    int finalPrice(int originalPrice);
}

class StandardPricing implements PricingPolicy {
    @Override
    public int finalPrice(int originalPrice) {
        return Math.max(0, originalPrice);
    }
}

class VipPricing implements PricingPolicy {
    @Override
    public int finalPrice(int originalPrice) {
        return Math.max(0, originalPrice) * 85 / 100;
    }
}
class ThresholdDiscountPricing implements PricingPolicy{
    public int finalPrice(int originalPrice){
        int price = Math.max(0,originalPrice);
        if(price >= 2000){
            return price -300;
        }
        return price;
    }
}

interface NotificationChannel {
    boolean send(String receiver, String message);
}

class EmailChannel implements NotificationChannel {
    @Override
    public boolean send(String receiver, String message) {
        if (receiver == null || !receiver.contains("@")) {
            return false;
        }
        System.out.println("EMAIL " + receiver + " -> " + message);
        return true;
    }
}

class ConsoleChannel implements NotificationChannel {
    @Override
    public boolean send(String receiver, String message) {
        System.out.println("CONSOLE " + receiver + " -> " + message);
        return true;
    }
}

class CheckoutService {
    private final PricingPolicy pricing;
    private final NotificationChannel channel;

    CheckoutService(PricingPolicy pricing, NotificationChannel channel) {
        this.pricing = pricing;
        this.channel = channel;
    }

    boolean checkout(String orderId, int originalPrice, String receiver) {
        if (orderId == null || orderId.isBlank() || originalPrice < 0) {
            return false;
        }
        int amount = pricing.finalPrice(originalPrice);
        return channel.send(receiver,
                "order=" + orderId + ", amount=" + amount);
    }
}

public class FlexibleCheckoutSystem {
    public static void main(String[] args) {
        CheckoutService vipEmail = new CheckoutService(
                new VipPricing(), new EmailChannel());
        CheckoutService regularConsole = new CheckoutService(
                new StandardPricing(), new ConsoleChannel());

        System.out.println("sent="
                + vipEmail.checkout("O100", 2000, "amy@example.com"));
        System.out.println("sent="
                + regularConsole.checkout("O101", 800, "counter"));
        System.out.println("sent="
                + vipEmail.checkout("O102", 500, "invalid"));
    }
}
