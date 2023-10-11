package calc.events;

import javafx.event.Event;
import javafx.event.EventType;

public class DeleteTextEvent extends Event {
    public static final EventType<DeleteTextEvent> DELETE_TEXT = new EventType<>("DELETE_TEXT");

    public DeleteTextEvent() {
        super(DELETE_TEXT);
    }
}
