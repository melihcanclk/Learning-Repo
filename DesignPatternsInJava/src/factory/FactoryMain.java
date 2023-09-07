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
