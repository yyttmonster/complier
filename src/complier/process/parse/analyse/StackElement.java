package complier.process.parse.analyse;

/**
 * @author 余
 * this class stand for element of stack
 * whick is coonsist of symbolName and productionNumber
 * symboleName is a String
 * productionNumber is a number representing which production the string belongs to
 */
public class StackElement {

    private String symbolName;

    private int productionNumber;

    public StackElement(String symbolName, int productionNumber) {
        this.symbolName = symbolName;
        this.productionNumber = productionNumber;
    }

    public String getSymbolName() {

        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public int getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(int productionNumber) {
        this.productionNumber = productionNumber;
    }
}
