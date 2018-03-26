package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    private File f;

    public WordInspection(File file) {
        this.f = file;
    }

    public int wordCount() throws Exception {
        Scanner reader = new Scanner(this.f);
        int count = 0;
        while (reader.hasNext()) {
            reader.next();
            count++;
        }
        return count;
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<String>();
        Scanner reader;
        try {
            reader = new Scanner(this.f, "UTF-8");
        } catch (FileNotFoundException e) {
            return lines;
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            lines.add(line);
        }
        return lines;
    }

    public List<String> wordsContainingZ() throws Exception {
        List<String> words = new ArrayList<String>();
        for (String word : readLines()) {
            if (word.contains("z")) {
                words.add(word);
            }
        }
        return words;
    }

    public List<String> wordsEndingInL() throws Exception {
        List<String> words = new ArrayList<String>();
        for (String word : readLines()) {
            if (word.endsWith("l")) {
                words.add(word);
            }
        }
        return words;
    }

    public List<String> palindromes() throws Exception {
        List<String> words = new ArrayList<String>();
        for (String word : readLines()) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                words.add(word);
            }
        }
        return words;
    }

    public List<String> wordsWhichContainAllVowels() throws Exception {
        List<String> words = new ArrayList<String>();
        String vowels = "aeiouyäö";
        for (String word : readLines()) {
            boolean good = true;
            for (int i=0; i<vowels.length(); i++) {
                if (word.indexOf(vowels.charAt(i)) == -1) {
                    good = false;
                    break;
                }
            }
            if (good) {
                words.add(word);
            }
        }
        return words;
    }
}
