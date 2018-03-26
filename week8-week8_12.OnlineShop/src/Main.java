public class Main {

    public static void main(String[] args) {
        Storehouse store = new Storehouse();
        store.addProduct("milk", 3, 10);
        store.addProduct("coffee", 5, 7);

        System.out.println("Prices:");
        System.out.println("milk: " + store.price("milk") + " " + store.stock("milk"));
        System.out.println("coffee: " + store.price("coffee") + " " + store.stock("coffee"));
        System.out.println("sugar: " + store.price("sugar") + " " + store.stock("sugar"));

        System.out.println("Products:");
        for (String product: store.products()) {
            System.out.println(product);
        }
    }
}
