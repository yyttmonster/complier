package complier.process.lexer.symbol;

import java.util.HashMap;

/**
 * digital +、++、-、--、*、:=、
 * logical ∧、∨、┐、<、<=、>、>=、=、!=>
 * a identity correspond a operator
 * the identity of digital operator is between 21 to 30
 * the identity of logical operator is between 31 to 40
 * 41 to 49 is reservation
 */
public class OperatorImp implements SymbolInterface {

    /**
     * operate +
     */
    private static final int PLUS = 21;

    /**
     * operate ++
     */
    private static final int SELFINCREASE = 22;

    /**
     * operate -
     */
    private static final int SUBTRACT = 23;

    /**
     * operate --
     */
    private static final int SELFDECREASE = 24;

    /**
     * operate *
     */
    private static final int MULTIPLY = 25;

    /**
     * operate :=
     */
    private static final int EQUAL = 26;

    /**
     * operate &&
     */
    private static final int AND = 31;

    /**
     * operate ||
     */
    private static final int OR = 32;

    /**
     * operate !
     */
    private static final int NOT = 33;

    /**
     * operate >
     */
    private static final int MORE = 34;

    /**
     * operate >=
     */
    private static final int MOREEQUAL = 35;

    /**
     * operate <
     */
    private static final int LESS = 36;

    /**
     * operate <=
     */
    private static final int LESSEQUAL = 37;

    /**
     * operate =
     */
    private static final int ISEQUAL = 38;

    /**
     * operate !=
     */
    private static final int NOTEQUAL = 39;

    @Override
    public void getMap(HashMap<String, Integer> hashMap) {
        hashMap.put("+", PLUS);
        hashMap.put("++", SELFINCREASE);
        hashMap.put("-", SUBTRACT);
        hashMap.put("--", SELFDECREASE);
        hashMap.put("*", MULTIPLY);
        hashMap.put(":=", EQUAL);
        hashMap.put("&&", AND);
        hashMap.put("||", OR);
        hashMap.put("!", NOT);
        hashMap.put(">", MORE);
        hashMap.put(">=", MOREEQUAL);
        hashMap.put("<", LESS);
        hashMap.put("<=", LESSEQUAL);
        hashMap.put("=", ISEQUAL);
        hashMap.put("!=", NOTEQUAL);
    }

}
