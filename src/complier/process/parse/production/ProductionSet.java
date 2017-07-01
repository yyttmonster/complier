package complier.process.parse.production;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 余
 *         It will produce a parse and build firstSet and followSet
 *         a array whose the first element is production's left part and others is right part
 *         It will be caled by ll(1) table to build ll(1) table
 */
public class ProductionSet {

    /**
     * * declaration
     * D -> int namelist|real namelist|char namelist|boolean namelist
     * (namelist -> namelist , variable|variable)
     * namelist -> variable namelist'
     * namelist' -> , variable | nought
     */

    private Set<String> nonterminals = new HashSet<>();
    private final int productionNumber = 10;
    private final int MAXWIDTH = 10;
    private int currentNumber = 0;
    private String[][] productionSet = new String[productionNumber][MAXWIDTH];
    private HashMap<String, HashSet<String>> firstSet = new HashMap<>();
    private HashMap<String, HashSet<String>> followSet = new HashMap<>();

    /**
     * every character of production you defining must divided by space
     * every production divided by ";"
     * format : nonterminals -> right part ;
     */
    public void setProductionSet() {
        addAproduction("" +
//                "D -> int namelist ;" +
//                "D -> real namelist ;" +
//                "D -> char namelist ;" +
//                "D -> boolean namelist ;" +
//                "namelist -> variable namelist namelist' ;" +
//                "namelist' -> , variable ;" +
//                "namelist' -> nought;" +
                "E -> T E' ;" +
                "E' -> + T E' ;" +
                "E' -> nought ;" +
                "T -> F T' ;" +
                "T' -> * F T' ;" +
                "T' -> nought ;" +
                "F -> ( E ) ;" +
                "F -> i ");
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

        initiateFollowSet();
        setFollowSet();
        setFollowSet();
        setFollowSet();
        for (String string : nonterminals) {
            System.out.print(string + ":  ");
            for (String firstChar : followSet.get(string)) {
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
    public void setFirstSet() {
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
                    for (int increament = 1; j + increament < MAXWIDTH && productionSet[i][j+increament] != null; increament++) {
                        // the next character is nonterminals, therefor add the firstSet of it into followSet of current character
                        // and if the next character's firstSet contain "nought" check it's next character
                        // non -> aerfa currentChar beita ,add firstSet of beita into currentChar
                        if (nonterminals.contains(productionSet[i][j + increament])) {
                            followSet.get(productionSet[i][j]).addAll(firstSet.get(productionSet[i][j + increament]));
                            if (firstSet.get(productionSet[i][j + increament]).contains("nought")) {
                                followSet.get(productionSet[i][j]).remove("nought");
                                continue;
                            }
                        }
                        //the next character is terminals, therefor add it into followSet of current character
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
                }
                else break;
            }
        }
    }

    /**
     * store production in a array
     */
    private void addAproduction(String parse) {
        for (String production : parse.split(";")) {
            String[] strings = production.split("( -> )");
            int length = strings.length;
            if (length != 2) {
                System.err.println("文法产生式:" + production + "定义错误!");
                return;
            }
            nonterminals.add(strings[0]);
            productionSet[currentNumber][0] = strings[0];
            int i = 1;
            for (String string : strings[1].split("\\s+")) {
                if (string.equals("")) continue;
                productionSet[currentNumber][i] = string;
                i++;
            }
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
}
