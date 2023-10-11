package chainOfResponsibility;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level){
        setLevel(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
