package compositeEntity;

public class CompositeEntity implements ICoarseGrained {
    private final ICoarseGrained coarseGrained;

    CompositeEntity() {
        coarseGrained = new CoarseGrainedClass();
    }


    @Override
    public void setData(String... data) {
        coarseGrained.setData(data);
    }

    @Override
    public String[] getData() {
        return coarseGrained.getData();
    }
}
