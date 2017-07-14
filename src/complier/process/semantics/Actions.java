package complier.process.semantics;

import complier.process.Tables.information.FunctionInfo;
import complier.process.Tables.table.GlobalTable;
import complier.process.Tables.table.SymbolTable;
import complier.process.parse.analyse.StackElement;
import complier.process.parse.production.SymbolNode;

/**
 * @author 余
 */
public class Actions {

    private GlobalTable globalTable = new GlobalTable();

    private SymbolTable symbolTable = new SymbolTable();

    public void buildTree(SymbolNode currentNode, StackElement currentElement) {
        switch (currentElement.getProductionNumber()) {
//            FunctionList -> Function  FunctionList
            case 1: {
                switch (currentNode.getSymbolName()) {
                    case "Function": {
                        setFather(currentNode, currentElement);
                        break;
//                        SymbolNode thisNode = new SymbolNode(currentElement.getSymbolName(), currentNode.getProductionNumber());
//                        currentNode.sonNode = thisNode;
//                        thisNode.fatherNode = currentNode;
//                        currentNode = thisNode;
                    }
                    case "FunctionList": {
                        setBrother(currentNode, currentElement);
                        break;
//                        SymbolNode thisNode = new SymbolNode(currentElement.getSymbolName(), currentElement.getProductionNumber());
//                        currentNode = getLastBrotherNode(currentNode, currentElement);
//                        if (currentNode == null) return;
//                        currentNode.NextBrotherNode = thisNode;
//                        thisNode.LastBrotherNode = currentNode;
//                        currentNode = thisNode;
                    }
                }
                break;
            }
//            FunctionList -> nought
            case 2: {
                break;
            }
//            Function -> type i ( arglist ) { Body }
            case 3: {
                switch (currentElement.getSymbolName()) {
                    case "type": {
                        setFather(currentNode, currentElement);
                        break;
                    }
                    case "i": {
                        setBrother(currentNode, currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        inertGlobalTable(currentNode);
                        break;
                    }
                    case "Body": {
                        setBrother(currentNode, currentElement);
                        currentNode.type = currentNode.LastBrotherNode  // {
                                .LastBrotherNode                        // )
                                .LastBrotherNode                        //arglist
                                .LastBrotherNode                        //(
                                .LastBrotherNode.type;                  //i
                        break;
                    }
                    default: setBrother(currentNode, currentElement);
                }
                break;
            }
//            Function -> void i ( arglist ) { Body }
            case 4:{
                switch (currentElement.getSymbolName()) {
                    case "void": {
                        setFather(currentNode, currentElement);
                        break;
                    }
                    case "i": {
                        setBrother(currentNode, currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        inertGlobalTable(currentNode);
                        break;
                    }
                    case "Body": {
                        setBrother(currentNode, currentElement);
                        currentNode.type = currentNode.LastBrotherNode  // {
                                .LastBrotherNode                        // )
                                .LastBrotherNode                        //arglist
                                .LastBrotherNode                        //(
                                .LastBrotherNode.type;                  //i
                        break;
                    }
                    default: setBrother(currentNode, currentElement);
                }
                break;
            }
//            type -> int
            case 5 :{
                setFather(currentNode, currentElement);break;
            }
//            type -> boolean
            case 6: {
                setFather(currentNode, currentElement);break;
            }
//            type -> char
            case 7 :{
                setFather(currentNode, currentElement);break;
            }
//            type -> real
            case 8: {
                setFather(currentNode, currentElement);break;
            }
//            arglist -> nought
            case 9:{
//               FunctionInfo functionInfo = this.searchGlobalTable(currentNode.LastBrotherNode.LastBrotherNode);
//               functionInfo.arglistSize = 0;
               break;
            }
//            arglist -> type i arglist'
            case 10 : {
                setFather(currentNode, currentElement);

            }
        }

    }

    private void setFather(SymbolNode currentNode, StackElement currentElement) {
        SymbolNode thisNode = new SymbolNode(currentElement.getSymbolName(), currentNode.getProductionNumber());
        currentNode.sonNode = thisNode;
        thisNode.fatherNode = currentNode;
        currentNode = thisNode;
    }

    private void setBrother(SymbolNode currentNode, StackElement currentElement) {
        SymbolNode thisNode = new SymbolNode(currentElement.getSymbolName(), currentElement.getProductionNumber());
        currentNode = getLastBrotherNode(currentNode, currentElement);
        if (currentNode == null) return;
        currentNode.NextBrotherNode = thisNode;
        thisNode.LastBrotherNode = currentNode;
        currentNode = thisNode;
    }

    private SymbolNode getLastBrotherNode(SymbolNode currentNode, StackElement currentElement) {
//        if (currentNode.getProductionNumber() == currentElement.getProductionNumber()) return currentNode;
        while (currentNode.fatherNode != null) {
            if (currentNode.getProductionNumber() == currentElement.getProductionNumber())
                return currentNode;
            currentNode = currentNode.fatherNode;
            currentNode.type = currentNode.sonNode.type;
        }
        System.err.println("error!!!");
        return null;
    }

    private void inertGlobalTable(SymbolNode currentNode) {
        globalTable.insert(new FunctionInfo(currentNode.type, currentNode.getSymbolName()));
    }

    private FunctionInfo searchGlobalTable (SymbolNode symbolNode){
        FunctionInfo functionInfo = globalTable.search(symbolNode.type,symbolNode.getSymbolName());
        if (functionInfo == null){
            System.err.println("Cont't found this function");
        }
        return functionInfo;
    }

}
