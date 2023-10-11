package calc.parser.rdp;

import calc.parser.ParseException;
import calc.parser.tokenizer.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class RecursiveDescentParser {
    private final Tokenizer tokenizer;
    private Token currentToken;

    public RecursiveDescentParser(String expression) {
        tokenizer = new Tokenizer(expression);
    }

    public BigDecimal eval() throws ParseException {
        currentToken = tokenizer.scanToken();
        return evalExpression();
    }

    private BigDecimal evalExpression() throws ParseException {
        var result = evalTerm();
        while (true) {
            switch (currentToken) {
                case EndToken ignored -> {
                    return result;
                }
                case ClosingBracketToken ignored -> {
                    return result;
                }
                case PlusToken ignored -> {
                    currentToken = tokenizer.scanToken();
                    result = result.add(evalTerm());
                }
                case MinusToken ignored -> {
                    currentToken = tokenizer.scanToken();
                    result = result.subtract(evalTerm());
                }
                default ->
                    throw new ParseException("Not an expression.");
            }
        }
    }

    private BigDecimal evalTerm() throws ParseException {
        var result = evalFactor();
        while (true) {
            switch (currentToken) {
                case MultiplyToken ignored -> {
                    currentToken = tokenizer.scanToken();
                    result = result.multiply(evalFactor());
                }
                case DivideToken ignored -> {
                    currentToken = tokenizer.scanToken();
                    try {
                        result = result.divide(evalFactor(), RoundingMode.HALF_UP);
                    } catch (ArithmeticException exc) {
                        throw new ParseException(exc.getMessage());
                    }
                }
                default -> {
                    return result;
                }
            }
        }
    }

    private BigDecimal evalFactor() throws ParseException {
        switch (currentToken) {
            case IntToken(BigDecimal value) -> {
                currentToken = tokenizer.scanToken();
                return value;
            }
            case OpeningBracketToken ignored -> {
                currentToken = tokenizer.scanToken();
                var result = evalExpression();
                if (currentToken instanceof ClosingBracketToken) {
                    currentToken = tokenizer.scanToken();
                    return result;
                } else {
                    throw new ParseException("Not a factor.");
                }
            }
            default -> throw new ParseException("Not a factor.");
        }
    }

}
