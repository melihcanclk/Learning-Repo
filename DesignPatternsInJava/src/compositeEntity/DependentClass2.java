package compositeEntity;

public class DependentClass2 implements Composite{
    private String data;

    @Override
    public void setData(String data){
        this.data = data;
    }

    @Override
    public String getData(){
        return data;
    }
}
