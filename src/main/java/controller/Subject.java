import java.util.ArrayList;
import java.util.List;

//create Subject Object
//when you have some action this class will update that action to log file and log sheet
//input is username,detail and result
public class Subject {
  private List<Observer> file = new ArrayList<Observer>();

  public void addfile(Observer i) {
    file.add(i);
  }

  public List getList() {
    return this.file;
  }
  public void update(String username,Object detail,String result){
    Logfile logFile = new Logfile("info");
    logFile.update(username,detail,result);
    LogOnGoogleSheet LogOnGoogle = new LogOnGoogleSheet();
    LogOnGoogle.update(username, detail, result);
  }

    

}


