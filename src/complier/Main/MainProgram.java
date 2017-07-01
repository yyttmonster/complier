package complier.Main;

import complier.process.error.IllegalCharException;
import complier.process.lexer.handler.Handler;
import complier.process.lexer.preprocess.Preprocess;
import complier.process.parse.production.ProductionSet;

import java.util.HashSet;

/**
 * test
 */
public class MainProgram {

    public static void main(String[] args) {
//        Handler handler = new Handler();
//        try {
//            handler.deal("\\\\while ( i>= j ){1+1 != 2;}");
//            handler.deal("while ( i>= j ){1+1 != 2;}");
//        } catch (IllegalCharException e) {
//            e.printStackTrace();
//        }


        ProductionSet productionSet = new ProductionSet();
        productionSet.setProductionSet();
    }
}
