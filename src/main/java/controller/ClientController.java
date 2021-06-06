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
    private showInformationController showInfo = new showInformationController();
    private showEnrollmentRatingController showEnroll = new showEnrollmentRatingController();
    private Context context;

    private MainView view = new MainView();

    Scanner s = new Scanner(System.in);

    private String username;
    private String password;
    private String command;
    private Boolean commandFlag = false;

    enrollCourseController enrollObject = new enrollCourseController();
    dropCourseController dropObject = new dropCourseController();

    Subject ObserveObject = new Subject();

    public void run() throws Exception {
        while(true) {
            
            // if user is already authenticated then run, if not login
            if (user.isAuth()) {
                
                view.head(username);

                view.waiting();
                command = s.nextLine();
                
                setFlag();

                // Admin only scope
                if (user.getRole().equals("admin")) {

                    switch (command) {
                        case "admin":
                            System.out.println("Admin");
                            clearFlag();
                            break;
                        case "show users":
                            List<List<Object>> data = userModel.getUsers();
                            for (List row : data) {
                                System.out.println(row);
                            }
                            clearFlag();
                            break;
                    }
                }

                // Admin and teacher scope
                if (user.getRole().equals("admin") || user.getRole().equals("teacher")) {
                    if(command.equals("enroll")){
                        System.out.print("Enter Student name : ");
                        String user = s.next();
                        System.out.print("Enter cID of Course : ");
                        String cID = s.next();
                        enrollObject.execute(user,cID );
                    }
                    else if (command.equals("drop")) {
                        System.out.print("Enter Student name : ");
                        String user = s.next();
                        System.out.print("Enter cID of Course : ");
                        String cID = s.next();
                        dropObject.execute(user,cID);
                    }
                    
                }
                
                // Student scope
                if (user.getRole().equals("student")) {
                    if(command.equals("enroll")){
                        System.out.print("Enter cID of Course : ");
                        String cID = s.next();
                        enrollObject.execute(username, cID);
                    }
                    else if (command.equals("drop")){
                        System.out.print("Enter cID of Course : ");
                        String cID = s.nextLine();
                        dropObject.execute(username,cID );
                        
                    }
                    else if (command.equals("show course")){
                        System.out.print("Enter cID of Course (press * for show all course) : ");
                        String cID = s.nextLine();
                        if(cID.equals("*")){
                       showInfo.execute();
                        }
                        else{
                            showInfo.execute(cID);
                        }

                    }
                    else if (command.equals("show enroll")){
                        showEnroll.execute(username);
                        
                        
                       

                    }

                }

                // Global scope
                if (true) {
                    if (command.equals("exit") || command.equals("q") || command.equals("quit")) {

                        // Exit sequence
                        view.exit(username);
                        break;
                    }

                    switch (command) {
                        case "role":
                            System.out.printf("My role is %s\n", user.getRole());
                            clearFlag();
                            break;
                    }
                }

                // if there're no command executed (flag not clear) print Unknow command.
                if (commandFlag) {
                    System.out.println("Unknow command.");
                }
            } else {

                view.head();

                System.out.println("Please Login or Register to the system.");
                System.out.println("Type register or login to continue...");
                System.out.print("$ ");

                command = s.nextLine();
                
                while (!user.isAuth()) {
                    if (command.equals("login")) {
                        System.out.print("username : ");
                        username = s.nextLine();
                        System.out.print("password : ");
                        password = s.nextLine();
                        System.out.println();
                        context = new Context(user);
                        context.execute(username, password);
                        
                        
                    } else if (command.equals("register")) {
                        System.out.println();
                        System.out.println("You are registering as a \"Student\".");
                        System.out.println("If you want to access using teacher account please contact admin...");
                        System.out.println();
                        System.out.print("Please enter your username(your first name) : ");
                        username = s.nextLine();
                        System.out.print("Please enter your surname : ");
                        String surname = s.nextLine();
                        System.out.print("Please enter your password : ");
                        password = s.nextLine();
                        System.out.print("Please enter your address : ");
                        String address = s.nextLine();
                        System.out.print("Please enter your telephone number : ");
                        String phone = s.nextLine();
                        System.out.print("Please enter your email : ");
                        String email = s.nextLine();
                        
                        
                       
                        System.out.println();

                        RegisterController registee = new RegisterController();
                        registee.set(username, surname, password, address, phone, email);
                        
                        context = new Context(registee);
                        context.execute();

                        context = new Context(user);
                        context.execute(username, password);
                    } else {
                        System.out.println("Unknow command.");
                        
                        ObserveObject.update("Unknown", "Unknow command", "failed");
                    }
                }
            }
            // reset command
            command = "";
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