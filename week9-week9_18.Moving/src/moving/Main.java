package moving;

import moving.domain.Item;
import moving.domain.Thing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // test your program here
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("passport", 2));
        items.add(new Item("toothbrush", 1));
        items.add(new Item("circular saw", 100));

        Collections.sort(items);
        System.out.println(items);

    }
}
