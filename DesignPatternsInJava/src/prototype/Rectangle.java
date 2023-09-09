package prototype;

public class Rectangle extends Shape{
    public Rectangle() {
        super("Rectangle");
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
