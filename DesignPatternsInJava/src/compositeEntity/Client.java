package compositeEntity;

public class Client {
    private final ICoarseGrained coarseGrained;

    Client() {
        coarseGrained = new CompositeEntity();
    }

    public void printData() {
        for (String arr: coarseGrained.getData()) {
            System.out.println(arr);
        }
    }

    public void setData(String ...data){
        coarseGrained.setData(data);
    }
}
