package complier.process.semantics;

import complier.process.Tables.SymbolInfo;
import complier.process.Tables.SymbolName;
import complier.process.Tables.SymbolTable;
import complier.process.lexer.handler.SymbolForParser;
import complier.process.parse.production.SymbolNode;

import java.util.Stack;

/**
 * @author 余
 */
public class Action {

    private int[] productionLengths;
    private SymbolTable symbolTable = new SymbolTable();
    private String[][] productionSet;


    public Action(String[][] productionSet,int[] productionLengths) {
        this.productionSet = productionSet;
        this.productionLengths = productionLengths;
    }

    private void insertTable (SymbolName symbolName, SymbolInfo symbolInfo) {
        if (symbolTable.search(symbolName) != null)
            System.err.println("The functiion has existed! ");
        symbolTable.insert(symbolName,symbolInfo);
    }

    public void nonterminalsAction (SymbolNode currentNode,int productionNumber, Stack<SymbolNode> symbolStack , SymbolForParser currentSymbol) {
        switch (productionNumber) {
            case 1 : {
                SymbolNode symbolNode1 = new SymbolNode("Function","",null);
                SymbolNode symbolNode2 = new SymbolNode("FunctionList","",symbolNode1);
                currentNode.chilrenNode = symbolNode2;
                symbolStack.push(symbolNode2);
                symbolStack.push(symbolNode1);
            }
            case 2 : return;
            case 3 : {
                SymbolNode symbolNode1 = new SymbolNode("type","",null);
                SymbolNode symbolNode2 = new SymbolNode("i","",symbolNode1);
                SymbolNode symbolNode3 = new SymbolNode("(","",symbolNode2);
                SymbolNode symbolNode4 = new SymbolNode("arglist","",symbolNode3);
                SymbolNode symbolNode5 = new SymbolNode(")","",symbolNode4);
                SymbolNode symbolNode6 = new SymbolNode("{","",symbolNode5);
                SymbolNode symbolNode7 = new SymbolNode("Body","",symbolNode6);
                SymbolNode symbolNode8 = new SymbolNode("}","",symbolNode7);
                currentNode.chilrenNode = symbolNode8;
                symbolNode2.type = symbolNode1.type;
                symbolStack.push(symbolNode8);
                symbolStack.push(symbolNode7);
                symbolStack.push(symbolNode6);
                symbolStack.push(symbolNode5);
                symbolStack.push(symbolNode4);
                symbolStack.push(symbolNode3);
                symbolStack.push(symbolNode2);
                symbolStack.push(symbolNode1);
            }
            case 4:{
                SymbolNode symbolNode1 = new SymbolNode("void","",null);
                SymbolNode symbolNode2 = new SymbolNode("i","",symbolNode1);
                SymbolNode symbolNode3 = new SymbolNode("(","",symbolNode2);
                SymbolNode symbolNode4 = new SymbolNode("arglist","",symbolNode3);
                SymbolNode symbolNode5 = new SymbolNode(")","",symbolNode4);
                SymbolNode symbolNode6 = new SymbolNode("{","",symbolNode5);
                SymbolNode symbolNode7 = new SymbolNode("Body","",symbolNode6);
                SymbolNode symbolNode8 = new SymbolNode("}","",symbolNode7);
                currentNode.chilrenNode = symbolNode8;
                symbolNode2.type = symbolNode1.type;
                symbolStack.push(symbolNode8);
                symbolStack.push(symbolNode7);
                symbolStack.push(symbolNode6);
                symbolStack.push(symbolNode5);
                symbolStack.push(symbolNode4);
                symbolStack.push(symbolNode3);
                symbolStack.push(symbolNode2);
                symbolStack.push(symbolNode1);
            }
            case 5:{
                SymbolNode symbolNode1 = new SymbolNode("int","int",null);
                currentNode.chilrenNode = symbolNode1;
                symbolStack.push(symbolNode1);
            }
            case 6:{
                SymbolNode symbolNode1 = new SymbolNode("boolean","boolean",null);
                currentNode.chilrenNode = symbolNode1;
                symbolStack.push(symbolNode1);
            }
            case 7:{
                SymbolNode symbolNode1 = new SymbolNode("char","char",null);
                currentNode.chilrenNode = symbolNode1;
                symbolStack.push(symbolNode1);
            }
            case 8:{
                SymbolNode symbolNode1 = new SymbolNode("real","real",null);
                currentNode.chilrenNode = symbolNode1;
                symbolStack.push(symbolNode1);
            }
            case 9:return;
            case 10:{
                SymbolNode symbolNode1 = new SymbolNode("type","",null);
                SymbolNode symbolNode2 = new SymbolNode("i","",symbolNode1);
                currentNode.chilrenNode = symbolNode2;
                symbolNode2.type = symbolNode1.type;
                symbolStack.push(symbolNode2);
                symbolStack.push(symbolNode1);
            }
        }
    }
    public void setProductionLength (int number,int value) {
        productionLengths[number] = value;
    }

    public int getProductionLength (int number) {
        return productionLengths[number];
    }

}

