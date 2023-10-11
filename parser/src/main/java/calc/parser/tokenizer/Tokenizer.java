package calc.parser.tokenizer;

import calc.parser.ParseException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Tokenizer {
    private static final Map<Character, Token> tokenMap = new HashMap<>();
    static {
        tokenMap.put('+', new PlusToken());
        tokenMap.put('-', new MinusToken());
        tokenMap.put('*', new MultiplyToken());
        tokenMap.put('/', new DivideToken());
        tokenMap.put('(', new OpeningBracketToken());
        tokenMap.put(')', new ClosingBracketToken());
    }

    private final String text;

    private int currentIdx;

    public Tokenizer(String text) {
        this.text = text;
        this.currentIdx = 0;
    }

    public Token scanToken() throws ParseException {
        if (currentIdx >= text.length()) {
            return new EndToken();
        }

        var currentChar = text.charAt(currentIdx);
        if (Character.isDigit(currentChar)) {
            return scanInt();
        } else if (tokenMap.containsKey(currentChar)) {
            return scanOperator(currentChar);
        } else {
            throw new ParseException(String.format(
                    "Can't scan char '%c' at %d in expression '%s'",
                    currentChar,
                    currentIdx,
                    text));
        }
    }

    private IntToken scanInt() throws ParseException {
        var beginIdx = currentIdx;
        while (currentIdx < text.length() && Character.isDigit(text.charAt(currentIdx))) {
            ++currentIdx;
        }

        if (beginIdx == currentIdx) {
            throw new ParseException(String.format("Not an int at position %d in expression '%s'", beginIdx, text));
        }

        return new IntToken(new BigDecimal(text.substring(beginIdx, currentIdx)));
    }

    private Token scanOperator(char currentChar) throws ParseException {
        ++currentIdx;
        if (tokenMap.containsKey(currentChar)) {
            return tokenMap.get(currentChar);
        } else {
            throw new ParseException(String.format("Unknown operator '%c'", currentChar));
        }
    }
}
