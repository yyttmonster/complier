package complier.process.parse.lltable;

import complier.process.parse.production.ProductionSets;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 余
 */
public class LL1Table {

    private HashMap<ElementName, Integer> table = new HashMap<>();
    private ProductionSets productionSets = new ProductionSets();
    private HashMap<String, HashSet<String>> firstSet = new HashMap<>();
    private HashMap<String, HashSet<String>> followSet = new HashMap<>();
    private String[][] productionSet;

    public void printTable(){
        for (ElementName elementName:table.keySet()){
            System.out.println(elementName.getNonterminals()+" "+elementName.getTerminal()+": "+table.get(elementName));
        }
    }

    public LL1Table() {
        firstSet = productionSets.getFirstSet();
        followSet = productionSets.getFollowSet();
        productionSet = productionSets.getProductionSet();
        builTable();
    }

    public void builTable() {
        for (int currentProductionNumber = 0; currentProductionNumber < productionSets.getCurrentNumber(); currentProductionNumber++) {
            HashSet<String> rightPartFirstSet = new HashSet<>();
            if (productionSet[currentProductionNumber][1].equals("nought")) {
                rightPartFirstSet.add("nought");
                continue;
            }
            // compute the firstSet of right part of production
            for (int characterNumber = 1;
                 characterNumber < productionSets.getMAXWIDTH() && productionSet[currentProductionNumber][characterNumber] != null;
                 characterNumber++) {
                if (productionSets.getNonterminals().contains(productionSet[currentProductionNumber][characterNumber])){
                    rightPartFirstSet.addAll(firstSet.get(productionSet[currentProductionNumber][characterNumber]));
                    if (firstSet.get(productionSet[currentProductionNumber][characterNumber]).contains("nought")) continue;
                }
                else rightPartFirstSet.add(productionSet[currentProductionNumber][characterNumber]);
            }

            //build LL(1)table
            if (rightPartFirstSet.contains("nought")) {
                for (String terminalLeft:followSet.get(productionSet[currentProductionNumber][0])){
                    table.put(new ElementName(productionSet[currentProductionNumber][0],terminalLeft),currentProductionNumber);
                }
            }
            for (String terminalRight : rightPartFirstSet){
                if (terminalRight.equals("nought")) continue;
                table.put(new ElementName(productionSet[currentProductionNumber][0],terminalRight),currentProductionNumber);
            }
        }
    }

    public HashMap<ElementName, Integer> getTable() {
        return table;
    }

//    public void insert(ElementName elementName, int productionNumber) {
//        table.put(elementName, productionNumber);
//    }

    public int searchTable(ElementName elementName) {
        int productionNumber;
        try {
            productionNumber = table.get(elementName);
        } catch (Exception e) {
            productionNumber = -100;
        }
        return productionNumber;
    }
}
