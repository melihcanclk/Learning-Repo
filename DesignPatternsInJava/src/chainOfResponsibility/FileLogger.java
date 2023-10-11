package chainOfResponsibility;

public class FileLogger extends AbstractLogger{

    public FileLogger(int level){
        setLevel(level);
    }
    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
