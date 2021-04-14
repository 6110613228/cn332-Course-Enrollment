package controller;

import view.MainView;
import model.UserModel;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
/**
 * ClientController
 * 
 * Context
 */
public class ClientController {

    private AuthController user = new AuthController();
    private UserModel userModel = new UserModel();
    private Context context;

    private MainView view = new MainView();

    Scanner s = new Scanner(System.in);

    private String username;
    private String password;
    private String command;
    private Boolean commandFlag = false;

    public void run() throws Exception {
        while(true) {

            // if user is already authenticated then run, if not login
            if (user.isAuth()) {

                view.head(username);

                view.waiting();
                command = s.nextLine();
                
                setFlag();

                // Admin only scope
                if (user.getRole() > 1) {

                    switch (command) {
                        case "status":
                            System.out.println("Admin");
                            clearFlag();
                            break;
                        default:
                            break;
                    }
                }

                // Admin and teacher scope
                if (user.getRole() > 0) {
                    
                    // do something
                }
                
                // Global scope
                if (true) {
                    if (command.equals("exit") || command.equals("q") || command.equals("quit")) {

                        // Exit sequence
                        view.exit(username);
                        break;
                    }
                }

                // if there're no command executed (flag not clear) print Unknow command.
                if (commandFlag) {
                    System.out.println("Unknow command.");
                }
            } else {

                view.head();
                System.out.println("Please Login.");
                System.out.print("username : ");
                username = s.nextLine();
                System.out.print("password : ");
                password = s.nextLine();
                System.out.println();

                context = new Context(user);
                context.execute(username, password);
            }
            System.out.println("...");
            view.foot();
            TimeUnit.MILLISECONDS.sleep(50);
        }
    }

    private void setFlag() {
        commandFlag = true;
    }

    private void clearFlag() {
        commandFlag = false;
    }
}