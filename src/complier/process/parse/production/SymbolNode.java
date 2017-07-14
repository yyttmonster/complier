package complier.process.parse.production;

/**
 * @author 余
 */

public class SymbolNode {

    private int productionNumber;

    private String symbolName ;

    public String type ="";

    public SymbolNode NextBrotherNode = null;

    public SymbolNode LastBrotherNode = null;

    public SymbolNode sonNode = null;

    public SymbolNode fatherNode = null;

    public int getProductionNumber() {
        return productionNumber;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public SymbolNode(String symbolName, int productionNumber){
        this.symbolName = symbolName;
        this.productionNumber = productionNumber;
    }
    @Override
    public String toString() {
        return "";
    }



//    public SymbolNode(String symbolName, String type,SymbolNode brotherNode) {
//        this.symbolName = symbolName;
//        switch (type) {
//            case "":{
//                this.type = -1;break;
//            }
//            case "void":{
//                this.type = 0;break;
//            }
//            case "int":{
//                this.type = 2;break;
//            }
//            case "real":{
//                this.type = 3;break;
//            }
//            case "char":{
//                this.type = 4;break;
//            }
//            case "boolean":{
//                this.type = 5;break;
//            }
//            default:this.type = -1;
//        }
//        this.brotherNode = brotherNode;
//    }

}