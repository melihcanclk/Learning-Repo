package factory;

public class FactoryProducer {

    public static AbstractFactory getShape(boolean isRounded) {
        return isRounded ? new RoundedShapeAbstractFactory() : new ShapeAbstractFactory();
    }
}
