package prototype;

public class Circle extends Shape{
    public Circle() {
        super("Circle");
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
