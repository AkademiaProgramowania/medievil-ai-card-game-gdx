package akademia.medievilai.server;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> cardsInHand;
    private List<Card> cardsCollection;
    private List<Card> cardsToReset;

    public Player() {
        cardsInHand = new ArrayList<>();
        cardsCollection = new ArrayList<>();
        cardsToReset = new ArrayList<>();

        cardsInHand.add(new Card(Resources.WOOD, 10));
        cardsInHand.add(new Card(Resources.STONE, 10));
        cardsInHand.add(new Card(Resources.CLAY, 10));

        cardsCollection.addAll(cardsInHand);
        cardsToReset.addAll(cardsInHand);
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public List<Card> getCardsCollection() {
        return cardsCollection;
    }

    public List<Card> getCardsToReset() {
        return cardsToReset;
    }

    public void updateCardsCollection(Card card) {
        cardsCollection.add(card);
    }
}
