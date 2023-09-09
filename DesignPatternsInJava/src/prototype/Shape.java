package prototype;

public abstract class Shape implements Cloneable{
    private String id;
    private final String type;

    Shape(String type) {
        this.type = type;
    }

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }


    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
