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
            Analyse analyse = new Analyse(handler.deal("int main () {" +
                    " int i := 1+3*4; " +
                    "int j;" +
                    "int m,n,w,e; " +
                    "j := 4*3; " +
                    "if ( m > n && w<= e  ) then { " +
                    "int k := 4; " +
                    "while ( m != w) do { int ll := 88; } }" +
                    " else { int p :=5 ;  }" +
                    "" +
                    "}" ));
            System.out.println("");
            analyse.analysing();
            analyse.result();
        } catch (IllegalCharException e) {
            e.printStackTrace();
        }

    }
}
