package interceptingFilter;

public class TargetFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}
