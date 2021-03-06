package complier.process.lexer.handler;

import complier.process.Tables.table.SymbolTable;
import complier.process.error.IllegalCharException;
import complier.process.lexer.preprocess.Preprocess;
import complier.process.lexer.symbol.*;

import java.util.ArrayList;


/**
 * @author 余
 *         handle the String array deal by preprocess
 *         output word
 */
public class Handler {

    private int code;
    private int value;
    private String strToken = "";
    private ArrayList<SymbolForParser> resultString = new ArrayList<>();
    private SymbolTable table = new SymbolTable();
    private SymbolCollection symbolCollection = new SymbolCollection();

    /**
     * divide a line of string to symbols
     *
     * @param stringLine a line of string
     * @return ArrayList
     * @throws IllegalCharException
     */
    public ArrayList<SymbolForParser> deal(String stringLine) throws IllegalCharException {
        Preprocess preprocess = new Preprocess();
        String[] afterPreprocess = preprocess.handle(stringLine);
        if (afterPreprocess == null) return null;
        for (String currentString : afterPreprocess) {
            determineStrToken(0, currentString);
        }
        return resultString;
    }

    /**
     * divide string to individual symbols
     *
     * @param position the position of pointer means that char before this position has been deal
     * @param str      a string that waiting for dealing
     * @throws IllegalCharException
     */
    private void determineStrToken(int position, String str) throws IllegalCharException {
        char ch;
        strToken = "";
        ch = str.charAt(position);
        //The first char is digit
        if (isDigit(ch)) {
            contact(ch);
            boolean isdecimals = false;
            for (int i = position + 1; i < str.length(); i++) {
                ch = str.charAt(i);
                if (isDigit(ch)) {
                    contact(ch);
                    continue;
                }
                if (ch == '.') {
                    if (isdecimals) throw new IllegalCharException("数字格式错误！");
                    isdecimals = true;
                    contact(ch);
                    continue;
                }
                if (isLetter(ch)) throw new IllegalCharException("非法字符！");
                //存入表
                System.out.println(strToken);
                if (isdecimals) resultString.add(new SymbolReal("id",symbolCollection.getSymbolType("int"),strToken,Double.valueOf(strToken)));
                else resultString.add(new SymbolInt("id",symbolCollection.getSymbolType("real"),strToken,Integer.valueOf(strToken)));
                determineStrToken(i, str);
                return;
            }
            resultString.add(new SymbolInt("id",symbolCollection.getSymbolType("int"),strToken,Integer.valueOf(strToken)));
            System.out.println(strToken);
            return;
        }
        if (isLetter(ch) || ch == '_') {
            contact(ch);
            for (int i = position + 1; i < str.length(); i++) {
                ch = str.charAt(i);
                if (isLetter(ch) || isDigit(ch) || ch == '_') {
                    contact(ch);
                    continue;
                }
                code = symbolCollection.getSymbolType(strToken);

                if (code > 0){
                    if (code == symbolCollection.getSymbolType("true")) resultString.add(new SymbolBoolean("id",code,strToken,true));
                    else if (code== symbolCollection.getSymbolType("false")) resultString.add(new SymbolBoolean("id",code,strToken,false));
                    else resultString.add(new SymbolVariables(strToken,code,strToken));
                }
                else resultString.add(new SymbolVariables("i",symbolCollection.getSymbolType("variables"),strToken));
                System.out.println(strToken+":"+code);//填入表
                determineStrToken(i, str);
                return;
            }
            if (strToken.equals("_")) throw new IllegalCharException("非法字符!");
            code = symbolCollection.getSymbolType(strToken);

//            if (code > 0) resultString.add(new SymbolForParser("id",strToken));
//            else resultString.add(new SymbolForParser("id",strToken));
            if (code > 0){
                if (code == symbolCollection.getSymbolType("true")) resultString.add(new SymbolBoolean("id",code,strToken,true));
                else if (code== symbolCollection.getSymbolType("false")) resultString.add(new SymbolBoolean("id",code,strToken,false));
                else resultString.add(new SymbolVariables(strToken,code,strToken));
            }
            else resultString.add(new SymbolVariables("i",symbolCollection.getSymbolType("variables"),strToken));

            System.out.println(strToken+":"+code);//填入表
            return;
        }

//        try {
//            code = hashMap.get(ch + "");
//        } catch (NullPointerException e) {
//            throw new IllegalCharException("非法字符!");

        code = symbolCollection.getSymbolType(ch + "");
//        if (code < 0) throw new IllegalCharException("非法字符!");

        contact(ch);
        if (position + 1 < str.length()) {
            try {
                int i = symbolCollection.getSymbolType(strToken + str.charAt(position + 1));
                if (i > 0) {
                    code = i;
                    position++;
                    contact(str.charAt(position));
                }
            } catch (NullPointerException e) {
                //do nothing because it only represents that this operator has only one char
            }
        }
        resultString.add(new SymbolVariables(strToken,code,strToken));
        System.out.println(strToken + ":" + code);//填表
        if (position + 1 < str.length())
            determineStrToken(position + 1, str);

    }

    /**
     * attach the ch to strToken
     *
     * @param ch a char
     */
    private void contact(char ch) {
        strToken += ch;
    }

//    /**
//     * put all symbol defined by system into hashMap
//     * OCP principle
//     */
//    private void setHashMap() {
//        SymbolInterface constant = new ConstantImp();
//        SymbolInterface delimiter = new DelimiterImp();
//        SymbolInterface operator = new OperatorImp();
//        constant.getMap(hashMap);
//        delimiter.getMap(hashMap);
//        operator.getMap(hashMap);
//    }

    /**
     * whether the char is a letter
     *
     * @param ch a char
     * @return if the ch is a letter return true , else return false
     */
    private boolean isLetter(char ch) {
        if (ch > 64 && ch < 91) return true;
        if (ch > 96 && ch < 123) return true;
        return false;
    }

    /**
     * whether the char is a digit
     *
     * @param ch a char
     * @return if the ch is a digit return true , else return false
     */
    private boolean isDigit(char ch) {
        if (ch > 47 && ch < 58) return true;
        return false;
    }

//    public void

}
