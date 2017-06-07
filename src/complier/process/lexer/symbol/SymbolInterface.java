package complier.process.lexer.symbol;

import java.util.HashMap;

/**
 * @author 余
 *         Interface
 */
public interface SymbolInterface {

    /**
     * put element to hashMap
     *
     * @param hashMap target map , element will be put into this hashMap
     */
    void getMap(HashMap<String, Integer> hashMap);
}
