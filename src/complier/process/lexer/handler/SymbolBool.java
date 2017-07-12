package complier.process.lexer.handler;

/**
 * @author 余
 */
public class SymbolBool extends SymbolForParser{
    private boolean value;

    public SymbolBool(String nickname, int tag, String name, boolean value) {
        super(nickname, tag, name);
        this.value = value;
    }

    public boolean isValue() {

        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
