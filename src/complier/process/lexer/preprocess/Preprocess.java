package complier.process.lexer.preprocess;

/**
 * delete blank and return a String array divided by blank
 */
public class Preprocess {

    public String[] handle (String input){
        String[] result = input.split("\\s+");
        return result;
    }

}
