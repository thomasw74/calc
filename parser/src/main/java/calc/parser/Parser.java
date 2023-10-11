package calc.parser;

import calc.parser.rdp.RecursiveDescentParser;

import java.math.BigDecimal;

public final class Parser {
    public static BigDecimal evaluate(String expression) throws ParseException {
        return new RecursiveDescentParser(expression).eval();
    }
}
