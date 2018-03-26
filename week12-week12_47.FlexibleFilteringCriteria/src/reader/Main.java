package reader;

import reader.criteria.Both;
import reader.criteria.Criterion;
import reader.criteria.ContainsWord;
import reader.criteria.EndsWithQuestionOrExclamationMark;

public class Main {

    public static void main(String[] args) {
        String address = "http://www.gutenberg.org/files/11/11-0.txt";
        GutenbergReader book = new GutenbergReader(address);

        Criterion criterion = new Both(new ContainsWord("maito"),new ContainsWord("vesi"));

        for (String line : book.linesWhichComplyWith(criterion)) {
            System.out.println(line);
        }
    }
}
