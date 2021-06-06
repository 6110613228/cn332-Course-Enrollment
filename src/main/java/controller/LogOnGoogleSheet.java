package controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.logtoSheet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//call from Subject Class
<<<<<<< HEAD
public class LogOnGoogleSheet extends Observer{
    
    public void update(String username,Object detail,String result){
=======
public class LogOnGoogleSheet extends Observer {
    
    public void update(String username,Object detail,String result) {
>>>>>>> 6acc407091fa469c6150b78022f130823b591217
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM-dd-yyyy hh:mm:ss a");
        String formattedDate = myDateObj.format(myFormatObj);
        logtoSheet log = new logtoSheet();
        log.addInfo(formattedDate,username,(String)detail,result);
    }

}