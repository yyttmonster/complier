package complier.process.semantics;

import java.util.HashMap;

/**
 * @author 余
 */
public class Four {

    private String[][] fourSet = new String[100][4];
    int fourCount = 100;

    public void addFour (int squenceNumber,String opr, String first, String second, String result){
        int i = squenceNumber - 100;
        fourSet[i][0] = opr;
        fourSet[i][1] = first;
        fourSet[i][2] = second;
        fourSet[i][3] = result;
        this.fourCount++;
    }

    public void printFour (){
        for (int i = 0; i < fourCount-100 && fourSet[i][0] != null;i++){
            System.out.println(i+100 + "  " + "(" +
                    fourSet[i][0] +
                    "," +
                    fourSet[i][1] +
                    "," +
                    fourSet[i][2] +
                    "," +
                    fourSet[i][3] +
                    ")");
        }
    }

}
