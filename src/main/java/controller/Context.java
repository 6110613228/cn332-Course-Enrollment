package controller;

/**
 * Context
 */
class Context {

    private Controller controller;

    public Context(Controller controller) {
        this.controller = controller;
    }

    public void execute() {
        controller.execute();
    }

    public void execute(Object a) {
        controller.execute(a);
    }

    public void execute(Object a, Object b) {
        controller.execute(a, b);
    }
}