package controller;

import model.UserModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * LoginController
 */
public class LoginController implements Controller {

    private Boolean authStatus = false; 

    public void login(String username, String password) throws IOException, GeneralSecurityException {
        UserModel model = new UserModel();
        List users = model.getUsers();

        System.out.println("Inside login method");
        authStatus = true;
    }

    public Boolean isAuth() {
        return authStatus;
    }

    public void execute() {
        try {
            login("abc", "123");
        } catch(Exception e) {
            // 
        }
        
        System.out.println("execute");
    }
}