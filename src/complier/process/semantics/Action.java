package complier.process.semantics;

import complier.process.Tables.SymbolTable;
import complier.process.lexer.handler.SymbolForParser;
import complier.process.parse.production.Symbol;

import java.util.Stack;

/**
 * @author 余
 */
public class Action {

    private int[] productionLengths = new int[100];
    private SymbolTable symbolTable = new SymbolTable();

    public void nonterminalsAction (int productionNumber,Stack<Symbol> symbolStack ,SymbolForParser currentSymbol) {
        switch (productionNumber) {
            case 0 : {
                BeginAction(symbolStack,currentSymbol);
            }
        }
    }

    private void BeginAction (Stack<Symbol> symbolStack ,SymbolForParser currentSymbol) {
        symbolStack.push(new Symbol("}",""));
        symbolStack.push(new Symbol("i","int"));
        symbolStack.push(new Symbol("int","dataclass"));

    }

    public void intAction () {

    }

    public void setProductionLength (int number,int value) {
        productionLengths[number] = value;
    }

    public int getProductionLength (int number) {
        return productionLengths[number];
    }

}

