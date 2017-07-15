package complier.process.semantics;

import complier.process.Tables.information.FunctionInfo;
import complier.process.Tables.information.Information;
import complier.process.Tables.table.GlobalTable;
import complier.process.Tables.table.SymbolTable;
import complier.process.parse.production.SymbolNode;

/**
 * @author 余
 */
public class Actions {

    static int squenceNumber = 99;

    private SymbolNode Root = new SymbolNode("FunctionList", 0);

    private SymbolNode currentNode = Root;

    private GlobalTable globalTable = new GlobalTable();

    private SymbolTable symbolTable = new SymbolTable();

    public void buildTree(SymbolNode currentElement) {
        System.out.println("chuli: "+currentNode.getSymbolName()+currentElement.getSymbolName() + currentElement.getProductionNumber());

        switch (currentElement.getProductionNumber()) {
            case 0:{
                break;
            }
//            FunctionList -> Function  FunctionList
            case 1: {
                switch (currentElement.getSymbolName()) {
                    case "Function": {
                        setFather(currentElement);
                        break;
//                        SymbolNode thisNode = new SymbolNode(currentElement.getSymbolName(), currentNode.getProductionNumber());
//                        currentNode.sonNode = thisNode;
//                        thisNode.fatherNode = currentNode;
//                        currentNode = thisNode;
                    }
                    case "FunctionList": {
                        setBrother(currentElement);
                        break;
//                        SymbolNode thisNode = new SymbolNode(currentElement.getSymbolName(), currentElement.getProductionNumber());
//                        currentNode = getLastBrotherNode(  currentElement);
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
                        setFather(currentElement);
                        break;
                    }
                    case "i": {
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        insertGlobalTable(currentNode);
                        break;
                    }
                    case "Body": {
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode  // {
                                .LastBrotherNode                        // )
                                .LastBrotherNode                        //arglist
                                .LastBrotherNode                        //(
                                .LastBrotherNode.type;                  //i
                        break;
                    }
                    default:
                        setBrother(currentElement);
                }
                break;
            }
//            Function -> void i ( arglist ) { Body }
            case 4: {
                switch (currentElement.getSymbolName()) {
                    case "void": {
                        setFather(currentElement);
                        break;
                    }
                    case "i": {
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        insertGlobalTable(currentNode);
                        break;
                    }
                    case "Body": {
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode  // {
                                .LastBrotherNode                        // )
                                .LastBrotherNode                        //arglist
                                .LastBrotherNode                        //(
                                .LastBrotherNode.type;                  //i
                        break;
                    }
                    default:
                        setBrother(currentElement);
                }
                break;
            }
//            type -> int
            case 5: {
                setFather(currentElement);
                break;
            }
//            type -> boolean
            case 6: {
                setFather(currentElement);
                break;
            }
//            type -> char
            case 7: {
                setFather(currentElement);
                break;
            }
//            type -> real
            case 8: {
                setFather(currentElement);
                break;
            }
//            arglist -> nought
            case 9: {
//               FunctionInfo functionInfo = this.searchGlobalTable(currentNode.LastBrotherNode.LastBrotherNode);
//               functionInfo.arglistSize = 0;
                break;
            }
//            arglist -> type i arglist
/**
 *
 */
            case 10: {
                switch (currentElement.getSymbolName()) {
                    case "type": {
                        setFather(currentElement);
                        break;
                    }
                    case "i": {
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        inserSymbolTable(currentNode);
                        break;
                    }
                    case "arglist'": {
                        setBrother(currentElement);
                        break;
                    }
                }
                break;
            }
//            arglist' -> , type i arglist'
            case 11: {
                switch (currentElement.getSymbolName()) {
                    case ",": {
                        setFather(currentElement);
                        break;
                    }
                    case "type": {
                        setBrother(currentElement);
                        break;
                    }
                    case "i": {
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        inserSymbolTable(currentNode);
                        break;
                    }
                    default: {
                        setBrother(currentElement);
                        break;
                    }
                }
                break;
            }
//            arglist' -> nought
            case 12: {
                break;
            }
//            Body -> Declaration ;
            case 13: {
                switch (currentElement.getSymbolName()) {
                    case ";": {
                        setBrother(currentElement);
                        break;
                    }
                    default: {
                        setFather(currentElement);
                        break;
                    }
                }
                break;
            }
//            Body -> Assignment ;
            case 14: {
                break;
            }
//            Body -> Block
            case 15: {
                break;
            }
//            Body -> nought
            case 16: {
                break;
            }
//            Body -> call
            case 17: {
                break;
            }
//            Declaration -> type namelist
            case 18: {
                switch (currentElement.getSymbolName()) {
                    case "type": {
                        setFather(currentElement);
                        break;
                    }
                    default: {
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            namelist -> B namelist'
            case 19: {
                switch (currentElement.getSymbolName()) {
                    case "B": {
                        setFather(currentElement);
                        currentNode.type = currentElement.fatherNode.type;
                        break;
                    }
                    default: {
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }

//            namelist' -> , B namelist'
            case 20: {
                switch (currentElement.getSymbolName()) {
                    case ",": {
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        break;
                    }
                    default: {
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            namelist' -> nought
            case 21: {
                break;
            }
//            B -> i B'
            case 22: {
                switch (currentElement.getSymbolName()) {
                    case "i": {
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        inserSymbolTable(currentNode);
                        break;
                    }
                    default: {
                        setBrother(currentElement);
                        currentNode.type = currentElement.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            B' -> ;= E
            case 23: {
                switch (currentElement.getSymbolName()) {
                    case ":=": {
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        break;
                    }
                    default: {
                        setBrother(currentElement);
                        currentElement.type = currentElement.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            B' -> nought
            case 24: {
                break;
            }
//            Assignment -> i := E ;
            case 25: {
                switch (currentNode.getSymbolName()) {
                    case "i": {
                        Information information = searchSymbolTable(currentNode);
                        currentNode.type = information.getType();
                        currentNode.setSymbolName(information.getName());
                        setFather(currentElement);
                        break;
                    }
                    case ":=": {
                        setBrother(currentElement);
                        break;
                    }
                    case "E": {
                        setBrother(currentElement);
                        currentElement.type = currentNode.LastBrotherNode.LastBrotherNode.type;
                        break;
                    }
                    case ";": {
                        setBrother(currentElement);
                        break;
                    }
                }
                break;
            }
//            E -> T E'
            case 26: {
                switch (currentElement.getSymbolName()){
                    case "T":{
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        break;
                    }
                    case "E'":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            E' -> + T E'
            case 27: {
                switch (currentElement.getSymbolName()) {
                    case "+":{
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        break;
                    }
                    case "T":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                    case "E'":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            E' -> - T E'
            case 28: {
                switch (currentElement.getSymbolName()) {
                    case "-":{
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        break;
                    }
                    case "T":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                    case "E'":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            E' -> nought
            case 29: {
                break;
            }
//            T -> F T'
            case 30: {
                switch (currentElement.getSymbolName()){
                    case "F":{
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        break;
                    }
                    case "T'":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            T' -> * F T'
            case 31: {
                switch (currentElement.getSymbolName()){
                    case "*":{
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        break;
                    }
                    case "F":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                    case "T'":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            T' -> nought
            case 32: {
                break;
            }
//            F -> - N
            case 33: {
                switch (currentElement.getSymbolName()){
                    case "-":{
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        break;
                    }
                    case "N":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                }
                break;
            }
//            F -> N
            case 34:{
                setFather(currentElement);
                currentNode.type = currentNode.fatherNode.type;
                break;
            }
//            N -> ( E )
            case 35:{
                switch (currentNode.getSymbolName()){
                    case "(":{
                        setFather(currentElement);
                        currentNode.type = currentNode.fatherNode.type;
                        break;
                    }
                    case "E":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;
                        break;
                    }
                    case ")":{
                        setBrother(currentElement);
                        currentNode.type = currentNode.LastBrotherNode.type;;
                        break;
                    }
                }
                break;
            }
//            N -> id
            case 36:{
                setFather(currentElement);
                currentNode.type = currentNode.fatherNode.type;
                break;
            }
//            N -> i
            case 37:{
                setFather(currentElement);
                Information information = searchSymbolTable(currentNode);
                currentNode.setSymbolName(information.getName());
               if (information.getType().equals(currentNode.fatherNode.type)){
                    System.out.println("type error");
                    return;
                }
                else  currentNode.type = information.getType();
                break;
            }
        }

    }

    private void setFather(SymbolNode currentElement) {
        currentNode.sonNode = currentElement;
        currentElement.fatherNode = currentNode;
        currentNode = currentElement;
    }

    private void setBrother(SymbolNode currentElement) {
        currentNode = getLastBrotherNode(currentElement);
        if (currentNode == null) return;
        currentNode.NextBrotherNode = currentElement;
        currentElement.LastBrotherNode = currentNode;
        currentElement.fatherNode = currentNode.fatherNode;
        currentNode = currentElement;
    }

    private SymbolNode getLastBrotherNode(SymbolNode currentElement) {
        if (currentNode.getProductionNumber() == currentElement.getProductionNumber()) return currentNode;
        while (currentNode.fatherNode != null) {
//            System.out.println(currentNode.getSymbolName() + currentNode.getProductionNumber() + "+" + currentElement.getSymbolName()+currentElement.getProductionNumber());
            currentNode = currentNode.fatherNode;
            currentNode.type = currentNode.sonNode.type;
            if (currentNode.getProductionNumber() == currentElement.getProductionNumber())
                return currentNode;
        }
        System.out.println("error!!!");
        return null;
    }

    private void insertGlobalTable(SymbolNode currentNode) {
        globalTable.insert(new FunctionInfo(currentNode.type, currentNode.getVariableName()));
    }

    private void inserSymbolTable(SymbolNode currentNode) {
        symbolTable.insert(currentNode.type, currentNode.getVariableName());
    }

    private Information searchSymbolTable(SymbolNode symbolNode) {
        return symbolTable.search(symbolNode.getVariableName());
    }

    private FunctionInfo searchGlobalTable(SymbolNode symbolNode) {
        FunctionInfo functionInfo = globalTable.search(symbolNode.type, symbolNode.getVariableName());
        if (functionInfo == null) {
            System.err.println("Cont't found this function");
        }
        return functionInfo;
    }

    public void ergodic (SymbolNode symbolNode1){
//        System.out.println("digui : "+symbolNode1.getSymbolName());
        if (symbolNode1.sonNode != null){
            ergodic(symbolNode1.sonNode);
        }
        System.out.println(symbolNode1.getSymbolName());
        if (symbolNode1.NextBrotherNode != null){
            ergodic(symbolNode1.NextBrotherNode);
        }
        return;
    }


    public SymbolNode getRoot() {
        return Root;
    }
}
