package complier.process.Tables.table;

import complier.process.Tables.information.Information;

import java.util.Stack;

/**
 * @author 余
 *         a table storing all varibles' information
 */

public class SymbolTable {

    private Stack<Information> symbolTable = new Stack<>();

    public int processNumber = 0;

    public void insert (String type,String variableName) {
        symbolTable.push(new Information(variableName,type,processNumber));
    }

    public Information search(String variableName){
        int size = symbolTable.size();
        while (size > 0){
            if (symbolTable.elementAt(size-1).getName().equals(variableName)){
                return symbolTable.elementAt(size -1);
            }
            size--;
        }
        System.err.println("Doesn't exist !!!");
        return null;
    }

    public void remove(){

    }
}
