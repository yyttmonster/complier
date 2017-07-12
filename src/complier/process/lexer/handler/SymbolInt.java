package complier.process.lexer.handler;

/**
 * @author 余
 */
public class SymbolInt extends SymbolForParser{
    private int value ;

    public SymbolInt(String nickname, int tag, String name, int value) {
        super(nickname, tag, name);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
