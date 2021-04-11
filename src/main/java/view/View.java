package view;

/**
 * View
 */
public class View {

    public void head(String username) {
        System.out.println("===========================================");
         System.out.printf("= %s ==================================\n", username);
        System.out.println("===========================================");
    }

    public void head() {
        System.out.println("===========================================");
        System.out.println("= Welcome =================================");
        System.out.println("===========================================");
    }
}