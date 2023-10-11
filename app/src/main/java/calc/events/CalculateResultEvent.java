package calc.events;

import javafx.event.Event;
import javafx.event.EventType;

public class CalculateResultEvent extends Event {
    public static final EventType<CalculateResultEvent> CALCULATE_RESULT = new EventType<>("CALCULATE_EVENT");

    public CalculateResultEvent() {
        super(CALCULATE_RESULT);
    }
}
