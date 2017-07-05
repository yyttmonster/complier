package complier.process.lexer.handler;

/**
 * @author 余
 */
public class SymbolForParser {
    private String nickname = "";
    private int tag ;
//    /**
//     * 2-int;
//     * 3-real;
//     * 4-char;
//     * 5-boolean;
//     */
//    private int type = 0;
    private int valueInt = -100;
    private Double valueDouble = -100.0;
    private String string = "";

    public SymbolForParser(String nickname, String string) {
        this.nickname = nickname;
        this.string = string;
    }

    public SymbolForParser(String nickname, int valueInt) {
        this.nickname = nickname;
        this.valueInt = valueInt;
    }

    public SymbolForParser(String nickname, Double valueDouble) {
        this.nickname = nickname;
        this.valueDouble = valueDouble;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getValueInt() {
        return valueInt;
    }

    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

    public Double getValueDouble() {
        return valueDouble;
    }

    public void setValueDouble(Double valueDouble) {
        this.valueDouble = valueDouble;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
