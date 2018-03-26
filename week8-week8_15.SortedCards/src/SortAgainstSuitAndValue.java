import java.util.Comparator;

public class SortAgainstSuitAndValue implements Comparator<Card> {
    public int compare(Card card1, Card card2) {
        int suitDiff = card1.getSuit() - card2.getSuit();
        if (suitDiff != 0) {
            return suitDiff;
        }
        return card1.compareTo(card2);
    }
}
