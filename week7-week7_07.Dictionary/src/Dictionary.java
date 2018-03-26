import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary = new HashMap<String, String>();

    public String translate(String word) {
        return this.dictionary.get(word);
    }

    public void add(String word, String translation) {
        this.dictionary.put(word, translation);
    }

    public int amountOfWords() {
        return this.dictionary.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> list = new ArrayList<String>();
        for (String key : dictionary.keySet()) {
            list.add(key + " = " + dictionary.get(key));
        }
        return list;
    }
}
