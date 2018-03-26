import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {
    private Map<String, Integer> prices = new HashMap<String, Integer>();
    private Map<String, Integer> stock = new HashMap<String, Integer>();

    public void addProduct(String product, int price, int stock) {
        if (prices.containsKey(product)) {
            return;
        }
        this.prices.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        if (prices.containsKey(product)) {
            return this.prices.get(product);
        }
        return -99;
    }

    public int stock(String product) {
        if (stock.containsKey(product)) {
            return this.stock.get(product);
        }
        return 0;
    }

    public boolean take(String product) {
        if (!stock.containsKey(product) || this.stock.get(product) == 0) {
            return false;
        }
        this.stock.put(product, this.stock.get(product)-1);
        return true;
    }

    public Set<String> products() {
        return this.prices.keySet();
    }
}
