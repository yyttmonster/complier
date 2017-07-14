//package complier.process.semantics;
//
//import complier.process.Tables.information.FunctionInfo;
//import complier.process.Tables.information.SymbolName;
//import complier.process.Tables.table.GlobalTable;
//import complier.process.Tables.table.SymbolTable;
//import complier.process.lexer.handler.SymbolForParser;
//import complier.process.parse.production.SymbolNode;
//
//import java.util.Stack;
//
///**
// * @author 余
// */
//
//public class Action {
//
//    private int[] productionLengths;
//    private SymbolTable symbolTable = new SymbolTable();
//    private String[][] productionSet;
//    private GlobalTable globalTable = new GlobalTable();
//    private String currentFunction = "";
//
//
//    public Action(String[][] productionSet, int[] productionLengths) {
//        this.productionSet = productionSet;
//        this.productionLengths = productionLengths;
//    }
//
//    private void insertTable(String returnType, String name) {
//        if (!globalTable.insert(new FunctionInfo(returnType, name))) {
//            System.out.println("This function has existed!");
//            return;
//        }
//        currentFunction = name;
//    }
//
//    public void nonterminalsAction(SymbolNode currentNode, int productionNumber, Stack<SymbolNode> symbolStack, SymbolForParser currentSymbol) {
//        switch (productionNumber) {
//            /*
//             * FunctionList -> Function  FunctionList
//             */
//            case 1: {
//                SymbolNode symbolNode1 = new SymbolNode("Function", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("FunctionList", "", symbolNode1);
//                currentNode.chilrenNode = symbolNode2;
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * FunctionList -> nought
//             */
//            case 2:
//                break;
//            /*
//             * Function -> type i ( arglist ) { Body }
//             * i.type = type.type
//             * (@ return) Body.type = type.type
//             * insert i -> table
//             */
//            case 3: {
//                SymbolNode symbolNode1 = new SymbolNode("type", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("i", "", symbolNode1);
//                SymbolNode symbolNode3 = new SymbolNode("(", "", symbolNode2);
//                SymbolNode symbolNode4 = new SymbolNode("arglist", "", symbolNode3);
//                SymbolNode symbolNode5 = new SymbolNode(")", "", symbolNode4);
//                SymbolNode symbolNode6 = new SymbolNode("{", "", symbolNode5);
//                SymbolNode symbolNode7 = new SymbolNode("Body", "", symbolNode6);
//                SymbolNode symbolNode8 = new SymbolNode("}", "", symbolNode7);
//                currentNode.chilrenNode = symbolNode8;
//                symbolNode2.type = symbolNode1.type;
//                symbolNode7.type = symbolNode1.type;
//                symbolStack.push(symbolNode8);
//                symbolStack.push(symbolNode7);
//                symbolStack.push(symbolNode6);
//                symbolStack.push(symbolNode5);
//                symbolStack.push(symbolNode4);
//                symbolStack.push(symbolNode3);
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * Function -> void i ( arglist ) { Body }
//             * i.type = void
//             * Body.type = i.type
//             */
//            case 4: {
//                SymbolNode symbolNode1 = new SymbolNode("void", "void", null);
//                SymbolNode symbolNode2 = new SymbolNode("i", "void", symbolNode1);
//                SymbolNode symbolNode3 = new SymbolNode("(", "", symbolNode2);
//                SymbolNode symbolNode4 = new SymbolNode("arglist", "", symbolNode3);
//                SymbolNode symbolNode5 = new SymbolNode(")", "", symbolNode4);
//                SymbolNode symbolNode6 = new SymbolNode("{", "", symbolNode5);
//                SymbolNode symbolNode7 = new SymbolNode("Body", "void", symbolNode6);
//                SymbolNode symbolNode8 = new SymbolNode("}", "", symbolNode7);
//                currentNode.chilrenNode = symbolNode8;
//                symbolStack.push(symbolNode8);
//                symbolStack.push(symbolNode7);
//                symbolStack.push(symbolNode6);
//                symbolStack.push(symbolNode5);
//                symbolStack.push(symbolNode4);
//                symbolStack.push(symbolNode3);
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * type -> int
//             * type.type = int.type
//             */
//            case 5: {
//                SymbolNode symbolNode1 = new SymbolNode("int", "int", null);
//                currentNode.type = symbolNode1.type;
//                currentNode.chilrenNode = symbolNode1;
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * type -> boolean
//             * type.type = int.type
//             */
//            case 6: {
//                SymbolNode symbolNode1 = new SymbolNode("boolean", "boolean", null);
//                currentNode.type = symbolNode1.type;
//                currentNode.chilrenNode = symbolNode1;
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * type -> char
//             * type.type = int.type
//             */
//            case 7: {
//                SymbolNode symbolNode1 = new SymbolNode("char", "char", null);
//                currentNode.type = symbolNode1.type;
//                currentNode.chilrenNode = symbolNode1;
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * type -> real
//             * type.type = int.type
//             */
//            case 8: {
//                SymbolNode symbolNode1 = new SymbolNode("real", "real", null);
//                currentNode.type = symbolNode1.type;
//                currentNode.chilrenNode = symbolNode1;
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * arglist -> nought
//             */
//            case 9:
//                break;
//            /*
//             * arglist -> type i arglist'
//             * i.type = type.type
//             */
//            case 10: {
//                SymbolNode symbolNode1 = new SymbolNode("type", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("i", "", symbolNode1);
//                SymbolNode symbolNode3 = new SymbolNode("arglist'", "", symbolNode2);
//                currentNode.chilrenNode = symbolNode3;
//                symbolNode2.type = symbolNode1.type;
//                symbolStack.push(symbolNode3);
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * arglist' -> , type i
//             * i.type = type.type
//             */
//            case 11: {
//                SymbolNode symbolNode1 = new SymbolNode(",", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("type", "", symbolNode1);
//                SymbolNode symbolNode3 = new SymbolNode("i", "", symbolNode2);
//                currentNode.chilrenNode = symbolNode3;
//                symbolNode2.type = symbolNode1.type;
//                symbolStack.push(symbolNode3);
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * arglist' -> nought
//             */
//            case 12: {
//                break;
//            }
//            /*
//             * Body -> Declaration ;
//             */
//            case 13: {
//                SymbolNode symbolNode1 = new SymbolNode("Declaration", "", null);
//                SymbolNode symbolNode2 = new SymbolNode(";", "", symbolNode1);
//                currentNode.chilrenNode = symbolNode2;
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * Body -> Assignment ;
//             */
//            case 14: {
//                SymbolNode symbolNode1 = new SymbolNode("Assignment", "", null);
//                SymbolNode symbolNode2 = new SymbolNode(":", "", symbolNode1);
//                currentNode.chilrenNode = symbolNode2;
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * Body -> Block
//             */
//            case 15: {
//                SymbolNode symbolNode1 = new SymbolNode("Block", "", null);
//                currentNode.chilrenNode = symbolNode1;
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * Body -> nought
//             */
//            case 16: {
//                break;
//            }
//            /*
//             * Body -> call
//             */
//            case 17: {
//                SymbolNode symbolNode1 = new SymbolNode("call", "", null);
//                currentNode.chilrenNode = symbolNode1;
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * Declaration -> type namelist
//             * namelist.type = type.type
//             */
//            case 18: {
//                SymbolNode symbolNode1 = new SymbolNode("type", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("namelist", "", symbolNode1);
//                symbolNode2.type = symbolNode1.type;
//                currentNode.chilrenNode = symbolNode2;
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * namelist -> B namelist'
//             * B.type = namelist.type
//             * namelist'.type = namelist.type
//             */
//            case 19: {
//                SymbolNode symbolNode1 = new SymbolNode("B", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("namelist'", "", symbolNode1);
//                symbolNode1.type = currentNode.type;
//                symbolNode2.type = currentNode.type;
//                currentNode.chilrenNode = symbolNode2;
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * namelist' -> , B namelist'
//             * B.type = namelist'.type
//             * namelist'.type = namelist'
//             */
//            case 20: {
//                SymbolNode symbolNode1 = new SymbolNode(",", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("B", "", symbolNode1);
//                SymbolNode symbolNode3 = new SymbolNode("namelist'", "", symbolNode2);
//                symbolNode2.type = currentNode.type;
//                symbolNode3.type = currentNode.type;
//                currentNode.chilrenNode = symbolNode2;
//                symbolStack.push(symbolNode3);
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * nameliist' -> nought
//             */
//            case 21: {
//                break;
//            }
//            /*
//             * B -> i B'
//             * i.type = B.type
//             * B'.type = B.type
//             */
//            case 22: {
//                SymbolNode symbolNode1 = new SymbolNode("i", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("B'", "", symbolNode1);
//                symbolNode1.type = currentNode.type;
//                symbolNode2.type = currentNode.type;
//                currentNode.chilrenNode = symbolNode2;
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * B' -> ;= E
//             * E.type = B'.type
//             */
//            case 23: {
//                SymbolNode symbolNode1 = new SymbolNode(":=", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("E", "", symbolNode1);
//                symbolNode2.type = currentNode.type;
//                currentNode.chilrenNode = symbolNode2;
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * B' -> nought
//             */
//            case 24: {
//                break;
//            }
//            /*
//             * Assignment -> i := E ;
//             * E.type = i.type
//             */
//            case 25: {
//                SymbolNode symbolNode1 = new SymbolNode("i", "", null);
//                SymbolNode symbolNode2 = new SymbolNode(":=", "", symbolNode1);
//                SymbolNode symbolNode3 = new SymbolNode("E", "", symbolNode2);
//                SymbolNode symbolNode4 = new SymbolNode(";", "", symbolNode3);
//                symbolNode3.type = symbolNode1.type;
//                currentNode.chilrenNode = symbolNode4;
//                symbolStack.push(symbolNode4);
//                symbolStack.push(symbolNode3);
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * E -> - E E'
//             * E.type = E.type
//             * E'.type = E.type
//             */
//            case 26: {
//                SymbolNode symbolNode1 = new SymbolNode("-", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("E", "", symbolNode1);
//                SymbolNode symbolNode3 = new SymbolNode("E'", "", symbolNode2);
//                symbolNode2.type = currentNode.type;
//                symbolNode3.type = currentNode.type;
//                currentNode.chilrenNode = symbolNode3;
//                symbolStack.push(symbolNode3);
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * E -> ( E ) E'
//             * E.type = E.type
//             * E'.type = E.type
//             */
//            case 27: {
//                SymbolNode symbolNode1 = new SymbolNode("(", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("E", "", symbolNode1);
//                SymbolNode symbolNode3 = new SymbolNode(")", "", symbolNode2);
//                SymbolNode symbolNode4 = new SymbolNode("E'", "", symbolNode3);
//                symbolNode2.type = currentNode.type;
//                symbolNode4.type = currentNode.type;
//                currentNode.chilrenNode = symbolNode4;
//                symbolStack.push(symbolNode4);
//                symbolStack.push(symbolNode3);
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * E -> i E'
//             * i.type = E.type
//             * E'.type = E.type
//             */
//            case 28: {
//                SymbolNode symbolNode1 = new SymbolNode("i", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("E'", "", symbolNode1);
//                symbolNode1.type = currentNode.type;
//                symbolNode2.type = currentNode.type;
//                currentNode.chilrenNode = symbolNode2;
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * E' -> opr E E'
//             * E.type = E'.type
//             * E'.type = E'.type
//             */
//            case 29: {
//                SymbolNode symbolNode1 = new SymbolNode("opr", "", null);
//                SymbolNode symbolNode2 = new SymbolNode("E", "", symbolNode1);
//                SymbolNode symbolNode3 = new SymbolNode("E'", "", symbolNode2);
//                symbolNode2.type = currentNode.type;
//                symbolNode3.type = currentNode.type;
//                currentNode.chilrenNode = symbolNode3;
//                symbolStack.push(symbolNode3);
//                symbolStack.push(symbolNode2);
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * opr -> +
//             */
//            case 30: {
//                SymbolNode symbolNode1 = new SymbolNode("+", "", null);
//                currentNode.chilrenNode = symbolNode1;
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * opr -> -
//             */
//            case 31: {
//                SymbolNode symbolNode1 = new SymbolNode("-", "", null);
//                currentNode.chilrenNode = symbolNode1;
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * opr -> *
//             */
//            case 32: {
//                SymbolNode symbolNode1 = new SymbolNode("*", "", null);
//                currentNode.chilrenNode = symbolNode1;
//                symbolStack.push(symbolNode1);
//                break;
//            }
//            /*
//             * E' -> nought
//             */
//            case 33: {
//                break;
//            }
//        }
//    }
//
//    public void setProductionLength(int number, int value) {
//        productionLengths[number] = value;
//    }
//
//    public int getProductionLength(int number) {
//        return productionLengths[number];
//    }
//
//}
//
//
