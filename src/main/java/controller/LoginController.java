package controller;

import model.UserModel;

import java.util.List;

/**
 * LoginController
 */
public class LoginController implements Controller {

    private Boolean authStatus = false; 

    public void login(String username, String password) {
        
        UserModel model = new UserModel();
        List user = model.getUser(username, password);
        
        if (user != null) {
            System.out.println("Login successful.");
            System.out.printf("you logged in as %s %s\n", user.get(1) ,user.get(2));
            authStatus = true;
        } else {
            System.out.println("Login failed");
        }
    }

    public Boolean isAuth() {
        return authStatus;
    }

    public void execute() {}

    public void execute(Object username, Object password) {
        try {
            login((String)username, (String)password);
        } catch(Exception e) {
            // 
        }
    }
}