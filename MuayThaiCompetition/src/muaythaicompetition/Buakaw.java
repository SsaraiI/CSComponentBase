/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muaythaicompetition;

/**
 *
 * @author iarsk
 */
public class Buakaw implements ObserverMT {
    @Override
    public void update(Source o) {
        System.out.println("(Buakaw) live result :  " + ((HeadQuater)o).getScoreLog());
    }
}
