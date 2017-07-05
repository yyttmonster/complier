package complier.process.parse.lltable;

/**
 * @author 余 consoting of a nonterminals and a terminal.
 *         It can identity a item of LL(1) table
 */
public class ElementName {

    /**
     * correspond with a row of table
     */
    private String nonterminals = "";
    /**
     * correspond with a column of table
     */
    private String terminal = "";

    /**
     * constructor
     *
     * @param nonterminals row of table
     * @param terminal     column of table
     */
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
