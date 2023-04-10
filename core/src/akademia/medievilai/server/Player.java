package akademia.medievilai.server;

import akademia.medievilai.server.Card;
import akademia.medievilai.server.Resources;
import akademia.medievilai.server.events.Event;
import akademia.medievilai.server.events.EventBus;
import akademia.medievilai.server.events.EventListener;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> cards;

    public Player() {
        cards = new ArrayList<>();
        cards.add(new Card(Resources.WOOD, 10));
        cards.add(new Card(Resources.STONE, 10));
        cards.add(new Card(Resources.CLAY, 10));
    }

    public List<Card> getCards() {
        return cards;
    }
}
