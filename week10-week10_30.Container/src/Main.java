import containers.ProductContainerRecorder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice.getName()); // Juice
        juice.addToTheContainer(1.0);
        System.out.println(juice);           // Juice: volume = 989.7, free space 10.3
// history() does not work properly, yet:
        System.out.println(juice.history()); // [1000.0]
        // in fact, we only retrieve the original value which was given to the constructor...
    }

}
