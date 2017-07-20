package complier.process.Tables.information;

/**
 * @author 余
 */
public class Information {

    private String name= "";

    private String type = "";

    public int processNumber = 0;

    private int valueInt = 0;

    private double valueReal = 0;

    private boolean valueBoolean = true;

    private char valueChar = ' ';

    private int arrayItem = 1;

    private int[] arrayNumber = new int[5];


    public Information(String name, String type, int processNumber) {
        this.name = name;
        this.type = type;
        this.processNumber = processNumber;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    private int typeFromString(String type) {
        switch (type) {
            case "int": return 0;
            case "real":return 1;
            case "boolean":return 2;
            case "char":return 3;
        }
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(int processNumber) {
        this.processNumber = processNumber;
    }

    public int getValueInt() {
        return valueInt;
    }

    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

    public double getValueReal() {
        return valueReal;
    }

    public void setValueReal(double valueReal) {
        this.valueReal = valueReal;
    }

    public boolean isValueBoolean() {
        return valueBoolean;
    }

    public void setValueBoolean(boolean valueBoolean) {
        this.valueBoolean = valueBoolean;
    }

    public char getValueChar() {
        return valueChar;
    }

    public void setValueChar(char valueChar) {
        this.valueChar = valueChar;
    }

    public int getArrayItem() {
        return arrayItem;
    }

    public void setArrayItem(int arrayItem) {
        this.arrayItem = arrayItem;
    }

    public int[] getArrayNumber() {
        return arrayNumber;
    }

    public void setArrayNumber(int[] arrayNumber) {
        this.arrayNumber = arrayNumber;
    }
}
