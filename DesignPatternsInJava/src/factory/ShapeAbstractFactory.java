package factory;

public class ShapeAbstractFactory extends AbstractFactory{
    @Override
    Shape getShape(String shapeType) {
        return switch (shapeType) {
            case "RECTANGLE" -> new Rectangle();
            case "SQUARE" -> new Square();
            default -> null;
        };
    }
}
