package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {
    private File file;

    public Analysis(File file) {
        this.file = file;
    }

    public int lines() throws Exception {
        Scanner reader = new Scanner(this.file);
        int count = 0;
        while (reader.hasNextLine()) {
            System.out.println(reader.nextLine());
            count++;
        }
        reader.close();
        return count;
    }

    public int characters() throws Exception {
        Scanner reader;
        reader = new Scanner(this.file);

        int count = 0;
        while (reader.hasNext()) {
            String token = reader.next();
            count += token.length();
            count++;
        }
        reader.close();
        return count;
    }
}
