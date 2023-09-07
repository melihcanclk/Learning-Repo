package factory;

public class ShapeFactory {

    public Shape createShape(String shapeName) {
        return switch (shapeName) {
            case "CIRCLE" -> new Circle();
            case "RECTANGLE" -> new Rectangle();
            case "SQUARE" -> new Square();
            default -> null;
        };
    }
}
