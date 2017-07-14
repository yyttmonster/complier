package complier.process.lexer.handler;

/**
 * @author 余
 */
public class SymbolBoolean extends SymbolForParser{

    private boolean value;

    public SymbolBoolean(String nickname, int tag, String name, boolean value) {
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
