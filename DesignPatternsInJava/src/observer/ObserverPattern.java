package observer;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();

        HexaObserver hexaObserver = new HexaObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        BinaryObserver binaryObserver = new BinaryObserver(subject);

        System.out.println("First state change: 15");
        System.out.println("======================");
        subject.setState(15);
        System.out.println("======================");
        System.out.println("Second state change: 20");
        System.out.println("======================");
        subject.setState(20);
        System.out.println("======================");

    }
}
