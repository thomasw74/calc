package calc.parser.tokenizer;

import java.math.BigDecimal;

public record IntToken(BigDecimal value) implements Token {
}
