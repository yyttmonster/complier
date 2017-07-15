package complier.process.parse.lltable;

import complier.process.parse.production.ProductionSets;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 余 building a LL(1) forecast analysis table after realizing firstSet and followSet
 */
public class LL1Table {

    /**
     * storing element of table
     * the Key is consist of ElementName.toString()
     * the value is the number of productions
     */
    private HashMap<String, Integer> table = new HashMap<>();

    private ProductionSets productionSets = new ProductionSets();
    private HashMap<String, HashSet<String>> firstSet = new HashMap<>();
    private HashMap<String, HashSet<String>> followSet = new HashMap<>();
    private String[][] productionSet;

    /**
     * print table
     */
    public void printTable() {
        for (String elementName : table.keySet()) {
            System.out.println(elementName  + ": " + table.get(elementName));
        }
    }

    /**
     * constructor
     */
    public LL1Table() {
        firstSet = productionSets.getFirstSet();
        followSet = productionSets.getFollowSet();
        productionSet = productionSets.getProductionSet();
        buildTable();
//        System.out.println(productionSets.getCurrentNumber());
        printTable();
    }

    /**
     * build LL(1) Table
     */
    private void buildTable() {
        for (int currentProductionNumber = 0; currentProductionNumber < productionSets.getCurrentNumber(); currentProductionNumber++) {
            HashSet<String> rightPartFirstSet = new HashSet<>();
            // compute the firstSet of right part of production
            if (productionSet[currentProductionNumber][1].equals("nought")) {
                rightPartFirstSet.add("nought");
            } else {
                for (int characterNumber = 1;
                     characterNumber < productionSets.getMAXWIDTH() && productionSet[currentProductionNumber][characterNumber] != null;
                     characterNumber++) {
                    if (productionSets.getNonterminals().contains(productionSet[currentProductionNumber][characterNumber])) {
                        rightPartFirstSet.addAll(firstSet.get(productionSet[currentProductionNumber][characterNumber]));
                        if (firstSet.get(productionSet[currentProductionNumber][characterNumber]).contains("nought"))
                            continue;
                    } else rightPartFirstSet.add(productionSet[currentProductionNumber][characterNumber]);
                    break;
                }
            }
            //build LL(1)table
            if (rightPartFirstSet.contains("nought")) {
                for (String terminalLeft : followSet.get(productionSet[currentProductionNumber][0])) {
                    table.put(new ElementName(productionSet[currentProductionNumber][0], terminalLeft).toString(), currentProductionNumber);
                }
            }
            for (String terminalRight : rightPartFirstSet) {
                if (terminalRight.equals("nought")) continue;
                table.put(new ElementName(productionSet[currentProductionNumber][0], terminalRight).toString(), currentProductionNumber);
            }
        }
    }

    public HashMap<String, Integer> getTable() {
        return table;
    }

//    public void insert(ElementName elementName, int productionNumber) {
//        table.put(elementName, productionNumber);
//    }

    /**
     * search LL(1)Table
     *
     * @param elementName the identity of a element of table consisting of a nonterminals and a terminal
     * @return the number of production (Integer)
     */
    public int searchTable(ElementName elementName) {
        int productionNumber;
        try {
            productionNumber = table.get(elementName.toString());
//            System.out.println("递推式："+productionNumber);
        } catch (Exception e) {
            productionNumber = -100;
        }
        return productionNumber;
    }

    public String[][] getProductionSet() {
        return productionSet;
    }

    public ProductionSets getProductionSets() {
        return productionSets;
    }
}
