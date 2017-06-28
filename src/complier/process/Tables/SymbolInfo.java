package complier.process.Tables;

/**
 * Created by 余 on 2017/6/28.
 */
public class SymbolInfo {

    private int Classify = -100;

    public SymbolInfo(int classify) {
        Classify = classify;
    }

    public int getClassify() {
        return Classify;
    }

    public void setClassify(int classify) {
        Classify = classify;
    }

}
