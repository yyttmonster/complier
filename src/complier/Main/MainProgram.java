package complier.Main;

import complier.process.error.IllegalCharException;
import complier.process.error.ParseException;
import complier.process.lexer.handler.Handler;
import complier.process.parse.analyse.Analyse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * test
 */
public class MainProgram {

    public static void main(String[] args) throws ParseException, IOException {

        int erroerLine = 1;

        BufferedReader reader = new BufferedReader(new FileReader("d:\\text"));
        String str;
        StringBuffer src = new StringBuffer();
        do {

            str = reader.readLine();
            if (str == null) {break;}
            if (str.length() == 0) continue;
            src.append(str);
        } while (str != null);


        Handler handler = new Handler();
        try {
//            Analyse analyse = new Analyse(handler.deal("int main (int b, int c) {" +
//                    " int i := 1+3*4  ;" +
//                    "int j;" +
//                    "boolean m,n,w,e; " +
//                    "j := 4*3; " +
//                    "if ( m > n || w== e  ) then { " +
//                    "array int kk[4+3][2]; " +
//                    "kk[1][2] := 3 ; " +
//                    "while ( m != w) do { int ll := 88; } }" +
//                    " else { int p :=5 ;  }" +
//                    "" +
//                    "}" ));
            Analyse analyse = new Analyse(handler.deal(src.toString()));
            System.out.println("");
                analyse.analysing();
                analyse.result();


        } catch (IllegalCharException e) {
            e.printStackTrace();
        }

    }
}
