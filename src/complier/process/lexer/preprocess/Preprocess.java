package complier.process.lexer.preprocess;

/**
 * delete blank and return a String array divided by blank
 */
public class Preprocess {

    public String[] handle (String input){
        if (input.charAt(0) == '\\' && input.charAt(1)=='\\') return null;
        return input.split("\\s+");
    }

}
