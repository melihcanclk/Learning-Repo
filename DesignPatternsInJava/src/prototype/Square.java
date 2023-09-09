package prototype;

public class Square extends Shape{
    public Square() {
        super("Square");
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
