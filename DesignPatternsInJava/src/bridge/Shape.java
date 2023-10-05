package bridge;

public abstract class Shape {
    private final Draw drawAPI;

    public Shape(Draw draw) {
        this.drawAPI = draw;
    }

    protected Draw getDrawAPI(){
        return drawAPI;
    }

    abstract void draw();
}
