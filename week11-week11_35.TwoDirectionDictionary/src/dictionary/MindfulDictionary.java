package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MindfulDictionary {
    private Map<String, String> dict = new HashMap<String, String>();
    private Map<String, String> dict2 = new HashMap<String, String>();
    private String fileToLoad;

    public MindfulDictionary() {

    }

    public MindfulDictionary(String file) {
        this.fileToLoad = file;
    }

    public boolean load() {
        File f = new File(this.fileToLoad);
        Scanner reader;
        try {
            reader = new Scanner(f);
        } catch (FileNotFoundException e) {
            return false;
        }
        while (reader.hasNextLine()) {
            String[] parts = reader.nextLine().split(":");
            add(parts[0], parts[1]);
        }
        return true;
    }

    public void add(String word, String translation) {
        if (dict.get(word) == null) {
            dict.put(word, translation);
            dict2.put(translation, word);
        }
    }

    public String translate(String word) {
        if (dict.get(word) != null) {
            return dict.get(word);
        }
        return dict2.get(word);
    }

    public void remove(String word) {
        if (dict.get(word) != null) {
            String translation = dict.get(word);
            dict.remove(word);
            dict2.remove(translation);
        } else {
            String translation = dict2.get(word);
            dict2.remove(word);
            dict.remove(translation);
        }
    }

    public boolean save() {
        FileWriter f;
        try {
            f = new FileWriter(this.fileToLoad);
            for (String word : this.dict.keySet()) {
                f.write(word + ":" + dict.get(word) + "\n");
            }
            f.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
