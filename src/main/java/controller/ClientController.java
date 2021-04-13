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

    public void run() throws Exception {
        while(true) {

            // if user is already authenticated then run, if not login
            if (user.isAuth()) {

                view.head(username);

                view.waiting();
                command = s.nextLine();
                
                // Admin only scope
                if (user.getRole() > 1) {

                    if (command.equals("show users")) {

                        List<List<Object>> data = userModel.getUsers();
                        for (List row : data) {
                            System.out.println(row);
                        }
                    }
                }

                // Admin and teacher scope
                if (user.getRole() > 0) {
                    
                    // do something
                }

                // Global scope
                if (command.equals("exit") || command.equals("q") || command.equals("quit")) {

                    // Exit sequence
                    view.exit(username);
                    break;
                } else {
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
            TimeUnit.SECONDS.sleep(1);
        }
    }
}