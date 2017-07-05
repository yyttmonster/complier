package complier.process.parse.production;

/**
 * @author 余
 */
public class Symbol {

    private String symbolName ;

    private String type ;

//    private

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Symbol(String symbolName, String type) {

        this.symbolName = symbolName;
        this.type = type;
    }
}