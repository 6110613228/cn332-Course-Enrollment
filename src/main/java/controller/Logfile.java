package controller;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//call from Subject class
public class Logfile extends Observer{
    private String filename;
    private Logger logger;
    private FileHandler fh;

    public Logfile(String filename) {
        try {
            this.filename = filename;
            fh = new FileHandler("./" + this.filename + ".log",true);
            logger = Logger.getLogger(filename);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.addHandler(fh);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void update(String username,Object detail,String result) {
        logger.info(username+" : "+(String) detail+" "+result);
    }
    

}