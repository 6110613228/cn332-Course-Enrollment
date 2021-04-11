import controller.*;

import java.util.List;
import java.io.IOException;
import java.security.GeneralSecurityException;
/**
 * Client
 */
public class Client {

    public static void main(String[] args) {

        LoginController l = new LoginController();
        Context context = new Context(l);
        context.execute("Triss", "triss");
        
        System.out.println(l.isAuth());
    }
}