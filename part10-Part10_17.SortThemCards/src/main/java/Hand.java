import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        this.cards.stream()
                .forEach(card -> System.out.println(card));
    }

    public void sort() {
        Collections.sort(cards, (c1, c2) -> c1.compareTo(c2));
    }

    @Override
    public int compareTo(Hand o) {
        int thisHand = 0;
        for (Card card : this.cards) {
            thisHand += card.getValue();
        }
        int oHand = 0;
        for (Card card : o.cards) {
            oHand += card.getValue();
        }

        if (thisHand == oHand) {
            return 0;
        } else if (thisHand > oHand) {
            return 1;
        } else {
            return -1;
        }
    }

    public void sortBySuit() {

        Collections.sort(cards, (c1, c2) -> new BySuitInValueOrder().compare(c1, c2));
    }
}
