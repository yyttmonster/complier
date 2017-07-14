package complier.process.Tables.information;

/**
 * @author 余
 */
public class FunctionInfo {

    public String name = "";

    public int arglistSize = 0;

    public String returnType = "void";

    /**
     * the first line are types of parameters
     * the twice line are name of parameters
     */
    public String[][] arglist = new String[5][5];

    /**
     * the index is corresponding the sequence number of parameter
     */
    public int[] arglistInt = new int[5];

    public char[] arglistChar = new char[5];

    public boolean[] arglistBoolean = new boolean[5];

    public double[] arglistReal = new double[5];

    public FunctionInfo(String returnType, String name) {
        this.name = name;
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return returnType+name;
    }


}
