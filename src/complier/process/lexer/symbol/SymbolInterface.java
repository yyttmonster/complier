package complier.process.lexer.symbol;

import java.util.HashMap;

/**
 * @author 余
 *         Interface
 */
public interface SymbolInterface {

    /**
     * put elements to hashMap
     *
     * @param hashMap target map , elements will be put into this hashMap
     */
    void getMap(HashMap<String, Integer> hashMap);
}
