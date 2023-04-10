package akademia.medievilai.server.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBusImplementation {

    private final Map<Event, List<EventListener>> allListeners;

    public EventBusImplementation() {
        allListeners = new HashMap<>();
        for (Event event : Event.values()) {
            allListeners.put(event, new ArrayList<EventListener>());
        }
    }

    public void subscribe(Event eventType, EventListener listener) {
        allListeners.get(eventType).add(listener);
    }

    public void unsubscribe(Event eventType, EventListener listener) {
        allListeners.get(eventType).remove(listener);
    }

    public void update(Event eventType) {
        List<EventListener> eventListeners = allListeners.get(eventType);
        for (EventListener listener : eventListeners) {
            listener.update(eventType);
        }
    }
}
