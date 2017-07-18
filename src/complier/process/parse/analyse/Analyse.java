package complier.process.parse.analyse;

import complier.process.lexer.handler.SymbolForParser;
import complier.process.parse.lltable.ElementName;
import complier.process.parse.lltable.LL1Table;
import complier.process.parse.production.SymbolNode;
import complier.process.semantics.Actions;
//import complier.process.semantics.Action;

import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;

/**
 * @author 余
 *         Analyse thought a forecast analysis table and stack
 */
public class Analyse {

    /**
     * symbol stack
     */
    private Stack<SymbolNode> symbolStack = new Stack<>();

    private LL1Table ll1Table;
    private String[][] productionSet;
    private ArrayList<SymbolForParser> inputString;
    private Set<String> nonterminals;
    //    private Action semanticAction;
    private Actions actions;
    public SymbolNode Root;
    private SymbolNode currentNode;


    public Analyse(ArrayList<SymbolForParser> inputString) {
//        for (SymbolForParser symbolForParser:inputString) System.out.println(symbolForParser.getNickname());
        ll1Table = new LL1Table();
        productionSet = ll1Table.getProductionSet();
        this.inputString = inputString;
        this.nonterminals = ll1Table.getProductionSets().getNonterminals();
//        this.semanticAction = ll1Table.getProductionSets().getSemanticAction();
        this.actions = new Actions();
        initiate();
    }

    private void initiate() {
//        symbolStack.push(new SymbolNode("#","#"));
        // push begining symbol into stack
//        symbolStack.push(new SymbolNode("FunctionList","",new F));
        Root = new SymbolNode("FunctionList", 1);
        currentNode = Root;
        symbolStack.push(new SymbolNode("FunctionList", 0));
    }

    public boolean analysing() {
        int characterNuber = 0;
        while (symbolStack.size() > 0 && characterNuber < inputString.size()) {
            SymbolNode peek = symbolStack.pop();
//            System.out.println("size:"+peek.getSymbolName()+symbolStack.size()+nonterminals.contains(peek.getSymbolName()));
            if (peek.getSymbolName().equals(inputString.get(characterNuber).getNickname())) {
//                if (peek.getSymbolName().equals("#")) return true;
                if (symbolStack.size() == 0) return true;
                System.out.println("peidui: "+peek.getSymbolName());
                peek.setVariableName(inputString.get(characterNuber).getName());
                if (peek.getSymbolName().equals("("))
                    System.out.println(peek);
                actions.buildTree(peek);
                characterNuber++;
                continue;
            }
            if (nonterminals.contains(peek.getSymbolName())) {
                int productionNumber = ll1Table.searchTable(new ElementName(peek.getSymbolName(), inputString.get(characterNuber).getNickname()));
                if (productionNumber < 0) {
                    System.out.println(symbolStack.size() + " " + peek.getSymbolName() + " " + inputString.get(characterNuber).getNickname());
                    System.out.println("LL1表里没你！！！");
                    return false;
                }
//                    semanticAction.nonterminalsAction(peek, productionNumber + 1, symbolStack, inputString.get(characterNuber));

                // right part of production is push into stack
                int i = 1;
                if (productionSet[productionNumber][i].equals("nought"))
                    continue;
                Stack<String> stack = new Stack<>();
//                System.out.println();
                while (productionSet[productionNumber][i] != null) {
                    System.out.print(productionSet[productionNumber][i] + " ");
                    stack.push(productionSet[productionNumber][i]);
                    i++;
                }
                System.out.println("                                                 "+productionNumber);
                while (!stack.isEmpty()) {
                    symbolStack.push(new SymbolNode(stack.pop(), productionNumber + 1));
                }
            }
            actions.buildTree(peek);
        }

        return false;
    }

    public void result (){
        actions.ergodic(actions.getRoot());
    }
}
