package footballusingevent;

import java.util.EventObject;

public class ScoreEvent extends EventObject{
    private String scline;
    
    public String getScoreLine(){
        return scline;
    }
    
    public ScoreEvent(Object source, String score){
        super(source);
        scline = score;
    }
}