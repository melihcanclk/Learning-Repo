package flyweight;

public class FlyweightPattern {
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeCache.getCircle(getRandomColor());
            circle.setX(getRandomNum());
            circle.setY(getRandomNum());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomNum() {
        return (int) (Math.random() * 100);
    }
}
