import controller.ClientController;

import java.util.List;
import java.io.IOException;
import java.security.GeneralSecurityException;
/**
 * Client
 */
public class Client {

    public static void main(String[] args) throws Exception {
        ClientController c = new ClientController();
        c.run();
    }
}