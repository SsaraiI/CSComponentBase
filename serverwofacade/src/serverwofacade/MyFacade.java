/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author iarsk
 */
public class MyFacade {
    ScheduleServer scheduleServer = new ScheduleServer();
    private static MyFacade myFacadeObj = null;
    private MyFacade(){}
    public static MyFacade getFacadeObject(){
        if(myFacadeObj == null) {
            myFacadeObj = new MyFacade();
        }
        return myFacadeObj;
    }
    
    public void startServer(){
	scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
	System.out.println("Start working......");
    }
    
    public void stopServer(){
    System.out.println("After work done.........");
	scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
}
