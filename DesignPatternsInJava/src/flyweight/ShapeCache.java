package flyweight;

import java.util.HashMap;

public class ShapeCache {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    // cache the circle object in the map and return it when needed
    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }

        return circle;
    }
}
