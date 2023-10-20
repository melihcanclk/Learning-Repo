package frontController;

public class FrontController {
    private Dispatcher dispatcher;

    public FrontController() {
        this.dispatcher = new Dispatcher();
    }

    private boolean authenticateUser() {
        System.out.println("User authenticated successfully");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request) {
        trackRequest(request);
        if(authenticateUser()) {
            dispatcher.dispatch(request);
        }
    }
}
