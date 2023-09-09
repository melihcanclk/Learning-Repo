package factory;


/**
 * We're going to create a Shape interface and concrete classes implementing the Shape interface. A factory class ShapeFactory is defined as a next step.
 * FactoryPatternDemo, our demo class will use ShapeFactory to get a Shape object. It will pass information (CIRCLE / RECTANGLE / SQUARE) to
 * ShapeFactory to get the type of object it needs.
 * <a href="https://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory Pattern</a>
 */
public class FactoryMain {
    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        Shape circle = sf.createShape("CIRCLE");
        circle.draw();

        Shape rectangle = sf.createShape("RECTANGLE");
        rectangle.draw();

        Shape square = sf.createShape("SQUARE");
        square.draw();
        System.out.println();
        // Abstract Factory Pattern

        AbstractFactory shapeFactory = FactoryProducer.getShape(false);
        AbstractFactory roundedFactory = FactoryProducer.getShape(true);

        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        shape1.draw();
        //get an object of Shape Square
        Shape shape2 = shapeFactory.getShape("SQUARE");
        //call draw method of Shape Square
        shape2.draw();

        Shape shape3 = roundedFactory.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        shape3.draw();
        //get an object of Shape Square
        Shape shape4 = roundedFactory.getShape("SQUARE");
        //call draw method of Shape Square
        shape4.draw();


    }
}
