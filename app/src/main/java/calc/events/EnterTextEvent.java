package calc.events;

import javafx.event.Event;
import javafx.event.EventType;

public class EnterTextEvent extends Event {
    public static final EventType<EnterTextEvent> ENTER_TEXT = new EventType<>("ENTER_TEXT");

    private final String text;

    public EnterTextEvent(String text) {
        super(ENTER_TEXT);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
