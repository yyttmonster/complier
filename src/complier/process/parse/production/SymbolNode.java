package complier.process.parse.production;

/**
 * @author 余
 */

public class SymbolNode {

    public String symbolName ;

    public int type ;

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
        switch (type) {
            case "":{
                this.type = -1;break;
            }
            case "void":{
                this.type = 0;break;
            }
            case "int":{
                this.type = 2;break;
            }
            case "real":{
                this.type = 3;break;
            }
            case "char":{
                this.type = 4;break;
            }
            case "boolean":{
                this.type = 5;break;
            }
            default:this.type = -1;
        }
        this.brotherNode = brotherNode;
    }
}