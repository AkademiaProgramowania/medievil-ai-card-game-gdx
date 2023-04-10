package akademia.medievilai.server.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {

    private static EventBusImplementation instance = new EventBusImplementation();

    public static void subscribe(Event eventType, EventListener listener) {
        instance.subscribe(eventType, listener);
    }

    public static void unsubscribe(Event eventType, EventListener listener) {
        instance.unsubscribe(eventType, listener);
    }

    public static void update(Event eventType) {
        instance.update(eventType);
    }
}
