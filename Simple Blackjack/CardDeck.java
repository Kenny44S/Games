import java.util.HashMap;
import java.util.Map;

public class CardDeck {

    public  Map<Integer, String> cards;

    public CardDeck()
    {
        cards = new HashMap<Integer, String>();
        InitiateCards();
    }

    private void InitiateCards()
    {
        cards.put(1, "A");
        cards.put(2, "2");
        cards.put(3, "3");
        cards.put(4, "4");
        cards.put(5, "5");
        cards.put(6, "6");
        cards.put(7, "7");
        cards.put(8, "8");
        cards.put(9, "9");
        cards.put(10, "10");
        cards.put(11, "J");
        cards.put(12, "Q");
        cards.put(13, "K");
    }
}
