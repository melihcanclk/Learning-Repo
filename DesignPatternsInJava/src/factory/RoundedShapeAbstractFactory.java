package factory;

public class RoundedShapeAbstractFactory extends AbstractFactory {
    @Override
    Shape getShape(String shapeType) {
        return switch (shapeType) {
            case "RECTANGLE" -> new RoundedRectangle();
            case "SQUARE" -> new RoundedSquare();
            default -> null;
        };
    }
}
