package mediator;

public class MediatorPattern {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi, my name is John");
        john.sendMessage("Hi, I'm Robert");
    }
}
