package footballusingevent;

import java.util.ArrayList;

public class ScoreSource {
    ArrayList<ScoreListener> sclist;

    public ScoreSource() {
        this.sclist = new ArrayList<>();
    }
    
    public void register (ScoreListener obj){
        sclist.add(obj);
    }
    
    public void removeRegister (ScoreListener observer){
        sclist.remove(observer);
    }
    
    public void setScoreLine(String data){
        fireHeadQuaterEvent(new ScoreEvent(this, data));
    }
    
    public void fireHeadQuaterEvent(ScoreEvent evt){
        for (ScoreListener observer : sclist){
            observer.scoreChange(evt);
        }
    }
}
