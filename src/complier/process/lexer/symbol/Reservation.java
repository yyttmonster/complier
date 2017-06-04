package complier.process.lexer.symbol;

import java.util.HashMap;

/**
 * all keywords
 * a identity correspond a keyword
 * the identity of other keyword is between 11 to 20
 */
public class Reservation {

    private static final int IF = 11;

    private static final int THEN = 12;

    private static final int ELSE = 13;

    private static final int WHILE = 14;

    private static final int DO = 15;

//    private static final int ARRAY = 16;

    public void getMap (HashMap<String,Integer> hashMap){
        hashMap.put("if",IF);
        hashMap.put("then",THEN);
        hashMap.put("else",ELSE);
        hashMap.put("while",WHILE);
        hashMap.put("do",DO);
//        hashMap.put("array",ARRAY);
    }
}
