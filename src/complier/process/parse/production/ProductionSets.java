package complier.process.parse.production;

//import complier.process.semantics.Action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 余
 *         It will produce a parse and build firstSet and followSet
 *         a array whose the first element is production's left part and others is right part
 *         It will be caled by ll(1) table to build ll(1) table
 */
public class ProductionSets {

    /**
     * function
     * Function -> type i ( arglist ) { Body } \
     * Function -> void i ( arglist ) { Body } \
     * type -> int  \
     * type -> boolean \
     * type -> char \
     * type -> real \
     * // arglist -> arglist , type i | type i
     * arglist -> nought \
     * arglist -> type i arglist' \
     * arglist' -> , type i arglist' \
     * arglist -> nought \
     * Body -> Declaration ; \
     * Body -> Assignment ; \
     * Body -> Block \
     * Body -> Call \
     * <p>
     * * declaration
     * <p>
     * //(namelist -> namelist ,B | B)
     * Declaration -> type namelist \
     * namelist -> B namelist' \
     * namelist' -> ,B namelist' \
     * nameliist' -> nought \
     * B -> i B' \
     * B' -> ;= E \
     * B' -> nought \
     * <p>
     * * Assignment
     * Assignment -> i := E ; \
     * <p>
     * * compute
     * E -> E + E | E * E | E - E | - E | ( E ) | i
     * E -> - E E' \
     * E -> ( E ) E'
     * E -> i E' \
     * E' -> + E E' \
     * E' -> * E E' \
     * E' -> - E E' \
     * E' -> nought \
     * <p>
     * * array
     * Array -> V := E \
     * E -> V \
     * V -> elist ] \
     * V -> i \                       elist -> elist , E | i [ E
     * elist -> i [ E elist' \
     * elist' -> , E elist' \
     * <p>
     * * condition
     * C -> if ( EB ) then \
     * S -> C S \
     * TP -> C S else \
     * S -> TP S \
     * W -> while \
     * WD -> W EB do \
     * S -> WD S \
     * L -> S \
     * LS -> S \
     * L -> LS S \
     * S -> begin L end
     * S -> A
     * <p>
     * * Boolean Expression
     * EB -> EB && EB | EB || EB | ! EB | ( EB )| E > E | E >= E | E < E | E <= E | E = E | E != E
     * EB -> EB && EB | EB || EB | ( EB ) | E E1     E1 -> > E | >= E | < E | <= E | = E | != E
     * EB -> E E1 EB' \
     * EB -> ! EB EB' \
     * EB -> ( EB ) EB' \
     * EB' -> && EB EB' \
     * EB' -> || EB \
     */

    private Set<String> nonterminals = new HashSet<>();
    private final int productionNumber = 100;
    private final int MAXWIDTH = 15;
    private int currentNumber = 0;
    private int[] productionLengths = new int[productionNumber];
    private String[][] productionSet = new String[productionNumber][MAXWIDTH];
    //    private Action semanticAction = new Action(productionSet, productionLengths);
    private HashMap<String, HashSet<String>> firstSet = new HashMap<>();
    private HashMap<String, HashSet<String>> followSet = new HashMap<>();

    public ProductionSets() {
        setProductionSet();
    }

    /**
     * every character of production you defining must divided by space
     * every production divided by ";"
     * format : nonterminals -> right part ;
     */
    private void setProductionSet() {
        addAproduction("" +
                "" +
//                "1" +
                "FunctionList -> Function  FunctionList \\" +
                "FunctionList -> nought \\" +
                "Function -> type i ( arglist ) { Blocklist } \\" +
                "Function -> void i ( arglist ) { Blocklist } \\" +
                "type -> int  \\" +
//                "5" +
                "type -> boolean \\" +
                "type -> char \\" +
                "type -> real \\" +
                "" +
                "arglist -> nought \\" +
                "arglist -> type i arglist' \\" +
//                "10" +
                "arglist' -> , type i arglist' \\" +
                "arglist' -> nought  \\" +
                "" +
                "Block -> Declaration ; \\" +
                "Block -> Assignment ; \\" +
                "Blocklist -> Block Blocklist  \\" +
//                "15" +
                "Blocklist -> nought \\" +
                "Block -> call i (  ) \\" +
                "" +
                "Declaration -> type namelist \\" +
                "namelist -> B namelist' \\" +
                "namelist' -> , B namelist' \\" +
//                "20" +
                "namelist' -> nought \\" +
                "B -> i B' \\" +
                "B' -> := E \\" +
                "B' -> nought \\" +
                "" +
                "Assignment -> i assignment ; \\" +
//                "Assignment -> i := E  \\" +
//                "25" +
                "E -> T E' \\" +
                "E' -> + T E' \\" +
                "E' -> - T E' \\" +
                "E' -> nought \\" +
                "T -> F T' \\" +
//                "30" +
                "T' -> * F T' \\" +
                "T' -> nought \\" +
                "F -> - N \\" +
                "F -> N \\" +
                "N -> ( E ) \\" +
//                "35" +
                "N -> id \\" +
                "N -> i item \\" +
                "Block -> if ( i S' S* ) then { Blocklist } else' \\" +
                "else' -> else { Blocklist } \\" +
                "else' -> nought \\" +
//                "40" +
                "Block -> while ( i S' S*  ) do { Blocklist } \\" +
                "Block -> do { Blocklist } while { i S' S*  } \\" +
                "S* -> && i S' \\" +
                "S* -> || i S' \\" +
                "S' -> nought \\" +
//                "45" +
                "S' -> rop i \\" +
                "S -> ( S ) \\" +
                "S -> ! S \\" +
                "rop -> > \\" +
                "rop -> >= \\" +
//                "50" +
                "rop -> < \\" +
                "rop -> <= \\" +
                "rop -> == \\" +
                "rop -> != \\" +
                "S* -> nought \\" +
//                "55" +
                "Declaration -> array type i [ E ] item \\" +
                "item -> [ E ] item \\" +
                "item -> nought \\" +
                "" +
                "assignment -> := E \\" +
                "assignment -> item := E \\" +
                "");
//        for (int i = 0; i < currentNumber; i++) {
//            System.out.println(productionSet[i][0] + "->" + productionSet[i][1] + " " + productionSet[i][2]);
//        }
//        for (String string : nonterminals) {
//            System.out.println(string);
//            System.out.println(nonterminals.contains("D"));
//        }
        initiateFirsSet();
        //call this function several time to ensure firstSet will not increase any more
        setFirstSet();
        setFirstSet();
        setFirstSet();
        setFirstSet();

        initiateFollowSet();
        setFollowSet();
        setFollowSet();
        setFollowSet();
        setFollowSet();
//        System.out.println(nonterminals.contains("namelist"));
        for (String string : nonterminals) {
            System.out.print(string + ":  ");
            for (String firstChar : firstSet.get(string)) {
                System.out.print(firstChar + ",");
            }
            System.out.println();
        }

    }

    /**
     * initiate
     */
    private void initiateFirsSet() {
        for (String string : nonterminals) {
            firstSet.put(string, new HashSet<>());
        }
    }

    /**
     * produce the firstSet of all nonterminals
     */
    private void setFirstSet() {
        for (int i = 0; i < productionNumber; i++) {
//            String currentChar = productionSet[i][0];
            for (int j = 1; productionSet[i][j] != null && j < MAXWIDTH; j++) {
                if (!nonterminals.contains(productionSet[i][j])) {
                    firstSet.get(productionSet[i][0]).add(productionSet[i][j]);
                    break;
                } else {
                    firstSet.get(productionSet[i][0]).addAll(firstSet.get(productionSet[i][j]));
                    if (!firstSet.get(productionSet[i][j]).contains("nought")) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * initiate the foloowSet of all nonterminals
     */
    private void initiateFollowSet() {
        for (String string : nonterminals) {
            followSet.put(string, new HashSet<>());
            //add # to followSet of s' which stands for begining
            if (string.equals("E")) followSet.get(string).add("#");
        }
    }

    /**
     * produce the followSet of all nonterminals
     */
    private void setFollowSet() {
        for (int i = 0; i < productionNumber; i++) {
            int j = 1;
            for (; productionSet[i][j] != null && j < MAXWIDTH; j++) {
                if (nonterminals.contains(productionSet[i][j])) {
                    // add followSet of left into the followSet of the character which is at end of right part
                    for (int increament = 1; j + increament < MAXWIDTH && productionSet[i][j + increament] != null; increament++) {
                        // the next character is nonterminals, therefore add the firstSet of it into followSet of current character
                        // and if the next character's firstSet contain "nought" check it's next character
                        // non -> aerfa currentChar beita ,add firstSet of beita into currentChar
                        if (nonterminals.contains(productionSet[i][j + increament])) {
                            followSet.get(productionSet[i][j]).addAll(firstSet.get(productionSet[i][j + increament]));
                            if (firstSet.get(productionSet[i][j + increament]).contains("nought")) {
                                followSet.get(productionSet[i][j]).remove("nought");
                                continue;
                            }
                            continue;
                        }
                        //the next character is terminals, therefore add it into followSet of current character
                        // non -> aerfa currentChar beita , firstSet
                        followSet.get(productionSet[i][j]).add(productionSet[i][j + increament]);
                        break;
                    }
                }
            }
//            System.out.println(j);
            //
            j--;
            for (; j > 0; j--) {
                if (nonterminals.contains(productionSet[i][j])) {
                    followSet.get(productionSet[i][j]).addAll(followSet.get(productionSet[i][0]));
                    if (!firstSet.get(productionSet[i][j]).contains("nought")) break;
                } else break;
            }
        }
    }

    /**
     * store production in a array
     */
    private void addAproduction(String parse) {
        for (String production : parse.split("\\\\")) {
            String[] strings = production.split("( -> )");
            int length = strings.length;
            if (length != 2) {
//                System.err.println("文法产生式:" + production + "定义错误!");
                continue;
            }
            nonterminals.add(strings[0]);
            productionSet[currentNumber][0] = strings[0].replaceAll(" ", "");
            int i = 1;
            int productionLength = 1;
            for (String string : strings[1].split("\\s+")) {
                if (string.equals("")) continue;
                productionSet[currentNumber][i] = string;
                i++;
                productionLength++;
                productionLengths[currentNumber] = productionLength;
            }
//            semanticAction.setProductionLength(currentNumber, productionLength);
            currentNumber++;
        }
    }


    /**
     * the method of getting all variables
     *
     * @return variables
     */

    public Set<String> getNonterminals() {
        return nonterminals;
    }

    public int getProductionNumber() {
        return productionNumber;
    }

    public int getMAXWIDTH() {
        return MAXWIDTH;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public String[][] getProductionSet() {
        return productionSet;
    }

    public HashMap<String, HashSet<String>> getFirstSet() {
        return firstSet;
    }

    public HashMap<String, HashSet<String>> getFollowSet() {
        return followSet;
    }

//    public Action getSemanticAction() {
//        return semanticAction;
//    }

}
