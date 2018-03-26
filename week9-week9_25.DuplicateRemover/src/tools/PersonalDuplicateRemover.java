package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> strings = new HashSet<String>();
    private int duplicates = 0;

    @Override
    public void add(String characterString) {
        if (!strings.add(characterString)) {
            this.duplicates++;
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.duplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.strings;
    }

    @Override
    public void empty() {
        this.strings.clear();
        this.duplicates = 0;
    }
}
