package complier.process.parse.production;

/**
 * @author 余
 */

public class SymbolNode {

    public String symbolName ;

    public String type ;

    public String value;

    public SymbolNode brotherNode;

    public SymbolNode chilrenNode = null;

//    private

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public SymbolNode(String symbolName, String type,SymbolNode brotherNode) {
        this.symbolName = symbolName;
        this.type = type;
        this.brotherNode = brotherNode;
    }
}