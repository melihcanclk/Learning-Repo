package factory;

public class FactoryMain {
    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        Shape circle = sf.createShape("CIRCLE");
        circle.draw();

        Shape rectangle = sf.createShape("RECTANGLE");
        rectangle.draw();

        Shape square = sf.createShape("SQUARE");
        square.draw();
    }
}
