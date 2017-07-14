package complier.process.Tables.information;

/**
 * @author 余
 */
public class Infomation {

    private String name= "";

    private int type = 0;

    public int processNumber = 0;

    private int valueInt = 0;

    private double valueReal = 0;

    private boolean valueBoolean = true;

    private char valueChar = ' ';


    public Infomation(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public int getvalue () {
        return 0;
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
