package view;

/**
 * View
 */
public class MainView {

    private String line = "===========================================";

    public void head(String username) {

        System.out.println(line);

        System.out.printf("= Welcome, " + "%s",username + " =");
        for (int i = 0; i < line.length() - (username.length()+13); i++) {
            System.out.print("=");
        }
        System.out.println();

        System.out.println(line);
        System.out.println();
    }

    public void head() {

        System.out.println(line);
        System.out.println("= Welcome =================================");
        System.out.println(line);
        System.out.println();
    }

    public void waiting() {
        System.out.print("Waiting for command $ ");
    }

    public void foot() {
        System.out.println();
        System.out.println(line);
        System.out.println(line);
        System.out.println();
    }

    public void exit(String username) {
        System.out.println();
        System.out.println("Thank you, " + username);
        System.out.println("Exit program");
        System.out.println("...");
        foot();
    }

}