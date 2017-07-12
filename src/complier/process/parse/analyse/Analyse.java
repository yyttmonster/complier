package complier.process.parse.analyse;

import complier.process.lexer.handler.SymbolForParser;
import complier.process.parse.lltable.ElementName;
import complier.process.parse.lltable.LL1Table;
import complier.process.parse.production.SymbolNode;
import complier.process.semantics.Action;

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
    private Stack<SymbolNode> symbolStack =  new Stack<>();

    private LL1Table ll1Table;
    private String[][] productionSet;
    private ArrayList<SymbolForParser> inputString;
    private Set<String> nonterminals;
    private Action semanticAction ;
    SymbolNode Root ;


    public Analyse(ArrayList<SymbolForParser> inputString) {
//        for (SymbolForParser symbolForParser:inputString) System.out.println(symbolForParser.getNickname());
        ll1Table = new LL1Table();
        productionSet = ll1Table.getProductionSet();
        this.inputString = inputString;
        this.nonterminals = ll1Table.getProductionSets().getNonterminals();
        this.semanticAction = ll1Table.getProductionSets().getSemanticAction();
        initiate();
    }

    private void initiate() {
//        symbolStack.push(new SymbolNode("#","#"));
        // push begining symbol into stack
//        symbolStack.push(new SymbolNode("FunctionList","",new F));
        Root =new SymbolNode("FunctionList","",null);
        symbolStack.push(Root);
    }

    public boolean analysing() {
        int characterNuber = 0;
        while (symbolStack.size() > 0 && characterNuber < inputString.size()) {
            SymbolNode peek = symbolStack.pop();
            if (peek.getSymbolName().equals(inputString.get(characterNuber).getNickname())) {
//                if (peek.getSymbolName().equals("#")) return true;
                if (symbolStack.size() == 0) return true;
                System.out.println(peek.getSymbolName());
                characterNuber++;
                continue;
            }
            if (nonterminals.contains(peek.getSymbolName())) {
//                System.out.println();
                int productionNumber = ll1Table.searchTable(
                        new ElementName(peek.getSymbolName(),
                                inputString.get(characterNuber).getNickname()));
                if (productionNumber < 0) {System.out.println("LL1表里没你！！！");return false;}
                semanticAction.nonterminalsAction(peek,productionNumber+1,symbolStack,inputString.get(characterNuber));

                /**
                 * test the LL1 table
                 */
//                int i = 1;
//                Stack<String> stack = new Stack<>();
//                while (productionSet[productionNumber][i] != null){
//                    stack.push(productionSet[productionNumber][i]);
//                    i++;
//                }
//                while (!stack.isEmpty()){
//                    symbolStack.push(new SymbolNode(stack.pop(),"",null));
//                }
//
            }
        }
        return false;
    }


}