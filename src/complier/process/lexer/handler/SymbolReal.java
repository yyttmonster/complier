package complier.process.lexer.handler;

/**
 * @author 余
 */
public class SymbolReal extends SymbolForParser{
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public SymbolReal(String nickname, int tag, String name, double value) {
        super(nickname, tag, name);
        this.value = value;
    }
}
