package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> translations = new HashMap<String, Set<String>>();

    @Override
    public void add(String word, String entry) {
        this.translations.putIfAbsent(word, new HashSet<String>());
        this.translations.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        return this.translations.get(word);
    }

    @Override
    public void remove(String word) {
        this.translations.remove(word);
    }
}
