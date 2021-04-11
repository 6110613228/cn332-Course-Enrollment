package controller;

/**
 * Context
 */
public class Context {

    private Controller controller;

    public Context(Controller controller) {
        this.controller = controller;
    }

    public void execute() {
        controller.execute();
    }
}