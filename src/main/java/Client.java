import controller.ClientController;
import controller.Subject;
import model.logtoSheet;

import java.util.List;
import java.io.IOException;
import java.security.GeneralSecurityException;
/**
 * Client
 */
public class Client {

    public static void main(String[] args) throws Exception {
        logtoSheet x = new logtoSheet();
        x.addInfo("test", "test", "test", "test");
        
        ClientController c = new ClientController();
        c.run();
    }
}