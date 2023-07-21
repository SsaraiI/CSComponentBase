/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_2;
import java.util.Scanner;
/**
 *
 * @author iarsk
 */
public class FootShape{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sn = new Scanner(System.in);
        System.out.print("What to draw? 1. Ellipse, 2. Rectangle ");
        int i = sn.nextInt();
        sn.close();
        if(i == 1){
            drawAsEllipse();
        }
        else if(i == 2){
            drawAsRectangle();
        }
    }
    
    public static void drawAsEllipse(){
        Foot e = new Ellipse();
        System.out.println(e.draw());
    }
    
    public static void drawAsRectangle(){
        Foot r = new Rectangle();
        System.out.println(r.draw());
    }
}
