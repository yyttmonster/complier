package complier.Main;

import complier.process.error.IllegalCharException;
import complier.process.lexer.handler.Handler;
import complier.process.parse.analyse.Analyse;

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

//        ProductionSets productionSets = new ProductionSets();
//        System.out.println(productionSets.getCurrentNumber());
//        productionSet.setProductionSet();

//        LL1Table ll1Table = new LL1Table();
//        ll1Table.printTable();

        Handler handler = new Handler();
        try {
            Analyse analyse = new Analyse(handler.deal("int main () { int i,j ; }"));

            System.out.println("");
            analyse.analysing();
        } catch (IllegalCharException e) {
            e.printStackTrace();
        }


    }
}
