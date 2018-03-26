package file;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // test your code here

        File file = new File("test/testfile.txt");
        Analysis analysis = new Analysis(file);
        try {
//            System.out.println("Lines: " + analysis.lines());
            System.out.println("Characters: " + analysis.characters());
        } catch (Exception e) {}
    }
}
