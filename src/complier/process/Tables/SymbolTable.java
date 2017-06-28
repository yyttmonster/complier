package complier.process.Tables;

import java.util.HashMap;

/**
 * @author 余
 * a table storing all varibles' information
 */
public class SymbolTable {

    HashMap<SymbolName, SymbolInfo> symbolTable = new HashMap<>();

    public HashMap<SymbolName, SymbolInfo> getSymbolTable() {
        return symbolTable;
    }

    public void insert(SymbolName name,SymbolInfo symbolInfo) {
        symbolTable.put(name,symbolInfo);
    }

    public void delete (SymbolName name){
        symbolTable.remove(name);
    }


}
