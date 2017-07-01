package complier.process.parse.lltable;

import java.util.HashMap;

/**
 * @author 余
 */
public class LL1Table {

    private HashMap<ElementName, Integer> table = new HashMap<>();

    public HashMap<ElementName, Integer> getTable() {
        return table;
    }

    public void insert(ElementName elementName, int procedureNumber) {
        table.put(elementName, procedureNumber);
    }

    public int searchTable(ElementName elementName) {
        int procedureNumber;
        try {
            procedureNumber = table.get(elementName);
        } catch (Exception e) {
            procedureNumber = -100;
        }
        return procedureNumber;
    }
}
