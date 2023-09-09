package prototype;

/**
 * We're going to create an abstract class Shape and concrete classes extending the Shape class.
 * A class ShapeCache is defined as a next step which stores shape objects in a Hashtable and returns their clone when requested.
 * PrototypPatternDemo, our demo class will use ShapeCache class to get a Shape object.
 */
public class PrototypeMain {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape circle = ShapeCache.getShape("1");
        System.out.println("Shape : " + circle.getType());
        circle.draw();

        Shape rectangle = ShapeCache.getShape("2");
        System.out.println("Shape : " + rectangle.getType());
        rectangle.draw();

        Shape square = ShapeCache.getShape("3");
        System.out.println("Shape : " + square.getType());
        square.draw();

    }
}
