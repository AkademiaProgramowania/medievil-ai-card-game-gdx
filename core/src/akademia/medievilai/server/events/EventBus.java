package akademia.medievilai.server.events;

public class EventBus {

    private static EventBusImplementation instance = new EventBusImplementation();

    public static void subscribe(Event eventType, EventListener listener) {
        instance.subscribe(eventType, listener);
    }

    public static void unsubscribe(Event eventType, EventListener listener) {
        instance.unsubscribe(eventType, listener);
    }

    public static void notify(Event eventType) {
        instance.notify(eventType);
    }
}
