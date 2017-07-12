package complier.process.lexer.handler;

/**
 * @author 余
 */
public abstract class SymbolForParser {
    private String nickname = "";
    private int tag ;
    private String name = "";

    public SymbolForParser(String nickname, int tag, String name) {
        this.nickname = nickname;
        this.tag = tag;
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
