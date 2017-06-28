package complier.process.parse.lltable;

/**
 * @author 余
 */
public class ElementName {

    private String nonterminals = "";
    private String terminal = "";

    public ElementName(String nonterminals, String terminal) {
        this.nonterminals = nonterminals;
        this.terminal = terminal;
    }

    public String getNonterminals() {
        return nonterminals;
    }

    public void setNonterminals(String nonterminals) {
        this.nonterminals = nonterminals;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
}
