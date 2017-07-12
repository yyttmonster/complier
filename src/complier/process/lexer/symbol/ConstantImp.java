package complier.process.lexer.symbol;

import java.util.HashMap;

/**
 * the identity of constants is between 2 to 10
 * the identity of all varies is 1
 */
public class ConstantImp implements SymbolInterface {

    private static final int VARIABLES =1 ;

    private static final int INT = 2;

    private static final int REAL = 3;

    private static final int CHAR = 4;

    private static final int BOOLEAN = 5;

    @Override
    public void getMap(HashMap<String, Integer> hashMap) {
        hashMap.put("variables",VARIABLES);
        hashMap.put("int", INT);
        hashMap.put("real", REAL);
        hashMap.put("char", CHAR);
        hashMap.put("boolean", BOOLEAN);
    }

}
