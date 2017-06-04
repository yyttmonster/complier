package complier.process.lexer.symbol;

import java.util.HashMap;

/**
 * (、)、[、]、{、}、,、;、'
 * the identity of delimiter is between 51 to 60
 * 61 to 70 is reservation
 */
public class Delimiter {
    /**
     *  Delimiter (
     */
    private static final int LSMALLBRACKETS= 51;

    /**
     * Delimiter )
     */
    private static final int RSMALLBRACKETS = 52;

    /**
     * Delimiter {
     */
    private static final int LMIDDLEBRACKETS = 53;

    /**
     * Delimiter ]
     */
    private static final int RMIDDLEBRACKETS = 54;

    /**
     *  Delimiter {
     */
    private static final int LBIGBRACKETS = 55;

    /**
     * Delimiter }
     */
    private static final int RBIGBRACKETS = 56;

    /**
     * Delimiter ,
     */
    private static final int COMMA = 57;

    /**
     *  Delimiter ;
     */
    private static final int SEMICOLON = 58;

    /**
     * Delimiter '
     */
    private static final int SIGLEQUOTATION = 59;

    public void getMap (HashMap<String,Integer> hashMap){
        hashMap.put("(",LSMALLBRACKETS);
        hashMap.put(")",RSMALLBRACKETS);
        hashMap.put("[",LMIDDLEBRACKETS);
        hashMap.put("]",RSMALLBRACKETS);
        hashMap.put("{",LBIGBRACKETS);
        hashMap.put("}",RBIGBRACKETS);
        hashMap.put(",",COMMA);
        hashMap.put(";",SEMICOLON);
        hashMap.put("'",SIGLEQUOTATION);
    }
}
