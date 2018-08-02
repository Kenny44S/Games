import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {

    private CardDeck cardDeck;

    private int totalHandValue = 0;
    private String playerName;

    public boolean busted = false;
    public boolean stay = false;
    public boolean twentyOne = false;
    public boolean blackJack = false;

    private List<Integer> cardsInHand;

    public Player()
    {
        cardsInHand = new ArrayList<Integer>();
        cardDeck = new CardDeck();
    }

    public Player(String playerName)
    {
        this.playerName = playerName;
        cardsInHand = new ArrayList<Integer>();
        cardDeck = new CardDeck();
    }



    public void updateTotalHandValue(int value)
    {
        totalHandValue += value;

        if(totalHandValue > 21)
            setBusted();
        else if(totalHandValue == 21)
            setTwentyOne();
    }


    public int getTotalHandValue()
    {
        return this.totalHandValue;
    }

    public String getPlayerName()
    {
        return this.playerName;
    }


    public void addCardToHand(int cardValue)
    {
        cardsInHand.add(cardValue);

        cardValue = cardValue > 10 ? 10 : cardValue;

        updateTotalHandValue(cardValue);
    }

    public void printCardsInHand()
    {
        for (Integer i : cardsInHand)
        {
            System.out.print(" " + cardDeck.cards.get(i));
        }
    }

    public void setStay()
    {
        stay = true;
    }

    public void setBusted()
    {
        busted = true;
    }

    public void setTwentyOne()
    {
        twentyOne = true;
    }
}
