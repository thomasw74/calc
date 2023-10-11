package calc.state;

import calc.parser.ParseException;
import calc.parser.Parser;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

import java.math.BigDecimal;

public final class DisplayState {
    private final ReadOnlyStringWrapper text = new ReadOnlyStringWrapper("");

    private String expression;

    private BigDecimal result;

    boolean error;

    public DisplayState() {
        reset();
    }

    public ReadOnlyStringProperty textProperty() {
        return text.getReadOnlyProperty();
    }

    public void addText(String textToAdd) {
        if (error || result != null) {
            reset();
        }
        expression += textToAdd;
        text.set(createDisplayText());
    }

    public void deleteText() {
        if (error || result != null) {
            reset();
        } else {
            if (!expression.isEmpty()) {
                expression = expression.substring(0, expression.length() - 1);
            }
        }
        text.set(createDisplayText());
    }

    public void calculateResult() {
        try {
            error = false;
            result = Parser.evaluate(expression);
        } catch (ParseException ex) {
            error = true;
        }
        text.set(createDisplayText());
    }

    private String createDisplayText() {
        if (error) {
            return "Error";
        } else if (result != null) {
            return expression + " = " + result;
        } else {
            return expression;
        }
    }

    private void reset() {
        expression = "";
        result = null;
        error = false;
    }

}
