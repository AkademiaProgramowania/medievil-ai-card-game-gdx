package akademia.medievilai.server;

import akademia.medievilai.server.events.Event;
import akademia.medievilai.server.events.EventBus;
import akademia.medievilai.server.events.EventListener;

public class TurnHandler implements EventListener {

    private int currentDay = 1;

    public TurnHandler() {
        EventBus.subscribe(Event.TURN_END, this);
    }

    @Override
    public void update(Event eventType) {
        switch (eventType) {
            case CARD_PLAYED:
                //card played
                break;
            case TURN_END:
                //turn end
                break;
        }
    }
}
