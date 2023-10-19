package compositeEntity;

public class DependentClass1 implements Composite {
    private String data;


    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }
}
