package footballusingevent;

import java.util.Scanner;

public class FootballUsingEvent {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        Subscriber sub1 = new Subscriber();
        Subscriber sub2 = new Subscriber();
        //Subscriber sub3 = new Subscriber();
        ScoreSource s = new ScoreSource();
        s.register(sub1);
        s.register(sub2);
        //s.register(sub3);
        String line;
        do {
            System.out.print("Enter Score ");
            line = sn.nextLine();
            if(line.length() > 0)
                s.setScoreLine(line);
        }while (line.length() > 0);
        sn.close();
        
        s.removeRegister(sub2);
        s.setScoreLine("check : remove register");
        
    }
    
}
