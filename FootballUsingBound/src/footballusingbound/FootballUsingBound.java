package footballusingbound;

import java.util.Scanner;

public class FootballUsingBound {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        LiveScoreBean livescb = new LiveScoreBean();
        Subscriber sub1 = new Subscriber();
        Subscriber sub2 = new Subscriber();
        livescb.addPropertyChangeListener(sub1);
        livescb.addPropertyChangeListener(sub2);
        String line;
        do {
            System.out.print("Enter Score ");
            line = sn.nextLine();
            if(line.length() > 0)
                livescb.setScoreLine(line);
        }while (line.length() > 0);
        sn.close();
        
        livescb.removePropertyChangeListener(sub2);
        livescb.setScoreLine("check : remove register");
    }
    
}
