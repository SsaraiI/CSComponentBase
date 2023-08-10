/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballcompetitionmt;
import java.util.ArrayList;


/**
 *
 * @author iarsk
 */
public class HeadQuater implements Source{
    private final ArrayList<ObserverMT> list;
    private String scoreLog;
    
    public HeadQuater(){
        this.list = new ArrayList<ObserverMT>();
    }
    
    public void setScoreLog(String log){
        scoreLog = log;
        notifyObserver();
    }
    
    public String getScoreLog(){
        return scoreLog;
    }
    
    @Override
    public void register (ObserverMT observer){
        list.add(observer);
    }
    
    @Override
    public void notifyObserver(){
        for(int i = 0; i < list.size(); i++) {
            list.get(i).update(this);
        }
    }
}
