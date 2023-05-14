package akademia.medievilai.server;

import akademia.medievilai.server.events.Event;
import akademia.medievilai.server.events.EventBus;
import akademia.medievilai.server.events.EventListener;

import java.util.ArrayList;
import java.util.List;

public class TurnHandler implements EventListener {

    private int currentDay = 1;
    private int maxMovementPoints = 3;
    private int currentMovementPoints = maxMovementPoints;
    private Player player;


    public TurnHandler(Player player) {
        EventBus.subscribe(Event.TURN_END, this);

        this.player = player;
    }

    public int getCurrentMovementPoints() {
        return currentMovementPoints;
    }

    public void setCurrentMovementPoints(int points) {
        currentMovementPoints = points;
    }

    @Override
    public void update(Event eventType) {
        switch (eventType) {
            case CARD_PLAYED:
                System.out.println("Card played");
                break;
            case TURN_END:
                currentDay++;
                resetMovementPoints();
                resetCards();
                break;
        }
    }

    private void resetMovementPoints() {
        currentMovementPoints = maxMovementPoints;
    }

    private void resetCards() {
        List<Card> cardsToReset = new ArrayList<>(player.getCardsToReset());
        player.getCardsInHand().clear();
        player.getCardsInHand().addAll(cardsToReset);
    }
}
