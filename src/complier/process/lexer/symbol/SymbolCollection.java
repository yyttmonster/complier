package complier.process.lexer.symbol;

import java.util.HashMap;

/**
 * @author 余
 */
public class SymbolCollection {

    HashMap<String, Integer> hashMap = new HashMap<>();

    public SymbolCollection(){
        setHashMap();
    }

    /**
     * put all symbol defined by system into hashMap
     * OCP principle
     */
    private void  setHashMap(){
        SymbolInterface constant = new ConstantImp();
        SymbolInterface delimiter = new DelimiterImp();
        SymbolInterface operator = new OperatorImp();
        SymbolInterface reservation = new ReservationImp();
        constant.getMap(hashMap);
        delimiter.getMap(hashMap);
        operator.getMap(hashMap);
        reservation.getMap(hashMap);
    }

    public int getSymbolType(String symbol) {
        int type = 0;
        try {
            type = hashMap.get(symbol);
        }catch (Exception e){
            type = -100;
        }
        return type;
    }
}
