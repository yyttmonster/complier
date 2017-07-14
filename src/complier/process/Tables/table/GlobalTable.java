package complier.process.Tables.table;

import complier.process.Tables.information.FunctionInfo;

import java.util.HashMap;

/**
 * @author 余
 *         global table will store all procedure name
 *         with some infomation ( arglists and type of return value)
 *         <p>
 *         User can't overLoad a function
 *         but maybe they could set a default value for parameter
 */
public class GlobalTable {

    private HashMap<String, FunctionInfo> functionTable = new HashMap<>();

    /**
     * add a new function
     *
     * @param functionInfo object of function
     * @return if name of function has existed,return false
     */
    public boolean insert(FunctionInfo functionInfo) {
        if (search(functionInfo.returnType, functionInfo.name) != null){
            System.err.println("This function has existed");
            return false;
        }
        functionTable.put(functionInfo.toString(), functionInfo);
        return true;
    }

    /**
     * search a function's information
     *
     * @param returnType the return tyep of function
     * @param name       function name
     * @return a functionInfo object
     */
    public FunctionInfo search(String returnType, String name) {
        try {
            return functionTable.get(returnType + name);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * remove a function
     *
     * @param returnType the return tyep of function
     * @param name       function name
     */
    public void remove(String returnType, String name) {
        functionTable.remove(returnType + name);
    }

    public HashMap<String, FunctionInfo> getFunctionTable() {
        return functionTable;
    }
}
