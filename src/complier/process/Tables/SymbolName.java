package complier.process.Tables;

/**
 * @author 余
 * a binary group <symbolName, processNumer> ,it will identity a unique symbol
 */
public class SymbolName {

    private String name;
    private int processNumber = 0;

    public SymbolName (int processNumber,String name) {
        this.name = name;
        this.processNumber = processNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(int processNumber) {
        this.processNumber = processNumber;
    }
}
