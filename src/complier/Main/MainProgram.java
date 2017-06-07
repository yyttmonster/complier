package complier.Main;

import complier.process.error.IllegalCharException;
import complier.process.lexer.handler.Handler;
import complier.process.lexer.preprocess.Preprocess;

/**
 * test
 */
public class MainProgram {

    public static void main(String[] args) {
        Handler handler = new Handler();
        try {
            handler.deal("while ( i > j )");
        } catch (IllegalCharException e) {
            e.printStackTrace();
        }
    }
}
