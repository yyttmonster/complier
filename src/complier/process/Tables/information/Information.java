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



}
