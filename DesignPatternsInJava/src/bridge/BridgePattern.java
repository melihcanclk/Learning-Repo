package bridge;

public class BridgePattern {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(), 100, 100 ,10);
        Shape greenCircle = new Circle(new GreenCircle(), 400, 400,20 );

        redCircle.draw();
        greenCircle.draw();
    }
}
