import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    private Map<String, Purchase> purchases = new HashMap<String, Purchase>();

    public void add(String product, int price) {
        Purchase purchase = this.purchases.get(product);
        if (purchase == null) {
            purchase = new Purchase(product, 0, price);
        }
        purchase.increaseAmount();
        this.purchases.put(product, purchase);

    }

    public int price() {
        int sum = 0;
        for (Purchase purchase : this.purchases.values()) {
            sum += purchase.price();
        }
        return sum;
    }

    public void print() {
        for (Purchase purchase : this.purchases.values()) {
            System.out.println(purchase);
        }
    }
}
