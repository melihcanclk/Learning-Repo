package bridge;

public class Circle extends Shape{
    private final int x, y, radius;

    public Circle(Draw draw, int x, int y, int radius) {
        super(draw);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    @Override
    void draw() {
        getDrawAPI().drawCircle(radius,x,y);
    }
}
