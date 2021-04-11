package controller;

import view.View;

import java.util.Scanner;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
/**
 * ClientController
 * 
 * Context
 */
public class ClientController {

    private LoginController user = new LoginController();
    private Context context;

    private View view = new View();

    Scanner s = new Scanner(System.in);

    private String username;
    private String password;

    public void run() throws Exception {
        while(true) {

            // if user is already authenticated then run, if not login
            if (user.isAuth()) {
                System.out.print("Waiting for command $ ");
                s.nextLine();
                break;
            } else {
                System.out.println(view.head());
                System.out.println("Please Login.");
                System.out.print("username : ");
                username = s.nextLine();
                System.out.print("password : ");
                password = s.nextLine();
                System.out.println();

                context = new Context(user);
                context.execute(username, password);
            }
            System.out.println("...\n");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}