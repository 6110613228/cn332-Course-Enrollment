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

    private AuthController user = new AuthController();
    private Context context;

    private View view = new View();

    Scanner s = new Scanner(System.in);

    private String username;
    private String password;
    private String command;

    public void run() throws Exception {
        while(true) {

            // if user is already authenticated then run, if not login
            if (user.isAuth()) {
                view.head(username);
                System.out.print("Waiting for command $ ");
                command = s.nextLine();
                
                if (command.equals("exit") || command.equals("q") || command.equals("quit")) {
                    System.out.println();
                    System.out.println("Thank you, " + username);
                    System.out.println("Exit program");
                    System.out.println("...");
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
            System.out.println("...\n");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}