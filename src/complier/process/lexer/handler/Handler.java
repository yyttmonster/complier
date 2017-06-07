package complier.process.lexer.handler;

import complier.process.error.IllegalCharException;
import complier.process.lexer.preprocess.Preprocess;
import complier.process.lexer.symbol.ConstantImp;
import complier.process.lexer.symbol.DelimiterImp;
import complier.process.lexer.symbol.OperatorImp;

import java.util.HashMap;

/**
 * @author 余
 * handle the String array deal by preprocess
 * output word
 */
public class Handler {

    private int code;
    private int value;
    private String strToken = "";
    private HashMap<String, Integer> hashMap = new HashMap<>();

    /**
     * divide a line of string to symbols
     *
     * @param stringLine a line of string
     * @throws IllegalCharException
     */
    public void deal(String stringLine) throws IllegalCharException {
        Preprocess preprocess = new Preprocess();
        String[] afterPreprocess = preprocess.handle(stringLine);
        setHashMap();

        for (String currentString : afterPreprocess) {
            determineStrToken(0, currentString);
        }
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
                determineStrToken(i, str);
                return;
            }
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
                System.out.println(strToken);//填入表
                determineStrToken(i, str);
                return;
            }
            System.out.println(strToken);//填入表
            return;
        }
        try {
            code = hashMap.get(ch + "");
        } catch (NullPointerException e) {
            throw new IllegalCharException("非法字符!");
        }
        contact(ch);
        if (position + 1 < str.length()) {
            try {
                int i = hashMap.get(strToken + str.charAt(position + 1));
                if (i > 0) {
                    code = i;
                    contact(ch);
                    position++;
                }
            }catch (NullPointerException e){
                //do nothing because it only represents that this operator has only one char
            }
        }
        System.out.println(strToken + ":" + code);//填表
        if (position + 1 < str.length()) determineStrToken(position + 1, str);
        return;
    }

    /**
     * attach the ch to strToken
     *
     * @param ch a char
     */
    public void contact(char ch) {
        strToken += ch;
    }

    /**
     * put all symbol defined by system into hashMap
     */
    private void setHashMap() {
        ConstantImp constant = new ConstantImp();
        DelimiterImp delimiter = new DelimiterImp();
        OperatorImp operator = new OperatorImp();
        constant.getMap(hashMap);
        delimiter.getMap(hashMap);
        operator.getMap(hashMap);
    }

    /**
     * whether the char is a letter
     *
     * @param ch a char
     * @return if the ch is a letter return true , else return false
     */
    public boolean isLetter(char ch) {
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
    public boolean isDigit(char ch) {
        if (ch > 47 && ch < 58) return true;
        return false;
    }

}
