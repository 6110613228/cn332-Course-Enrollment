package controller;
import java.util.ArrayList;
import java.util.List;
import model.logtoSheet;


//create Subject Object
//when you have some action this class will update that action to log file and log sheet
//input is username,detail and result
public class Subject {
  
  public void update(String username,Object detail,String result){
    Logfile logFile = new Logfile("info");
    logFile.update(username,detail,result);
    LogOnGoogleSheet LogOnGoogle = new LogOnGoogleSheet();
    LogOnGoogle.update(username, detail, result);
    
  }

    

}


