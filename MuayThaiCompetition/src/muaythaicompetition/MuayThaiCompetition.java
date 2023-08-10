/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muaythaicompetition;
import java.util.Scanner;

/**
 *
 * @author iarsk
 */
public class MuayThaiCompetition {

    /**
     * @param args the command line arguments
     */
    
    //Thai 1-0 UAE input
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        Buakaw buakaw = new Buakaw();
        Somluck somluck = new Somluck(); 
        HeadQuater s = new HeadQuater();
        s.register(buakaw);
        s.register(somluck);
        String line;
        do {
            System.out.print("enter Score ");
            line = sn.nextLine();
            s.setScoreLog(line);
        }while (line.length() > 0);
        sn.close();
    }
    
}
