import controller.*;

import java.util.List;
import java.io.IOException;
import java.security.GeneralSecurityException;
/**
 * Client
 */
public class Client {

    public static void main(String[] args) throws IOException, GeneralSecurityException {

        Context context = new Context(new LoginController());
        context.execute();
    }
}