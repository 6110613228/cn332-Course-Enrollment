import model.UserModel;
import java.util.List;
import java.io.IOException;
import java.security.GeneralSecurityException;
/**
 * Client
 */
public class Client {

    public static void main(String[] args) throws IOException, GeneralSecurityException {

        UserModel model = new UserModel();
        List result = model.getUser(1);

        System.out.println(result);
    }
}