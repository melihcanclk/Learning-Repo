package compositeEntity;

import java.util.Arrays;

public class CoarseGrainedClass implements ICoarseGrained{
    private final Composite[] composites = {new DependentClass1(), new DependentClass2()};

    @Override
    public void setData(String... data) {
       int min= Math.min(data.length, composites.length);
       for(int i = 0; i < min; i++) {
           composites[i].setData(data[i]);
       }
    }

    @Override
    public String[] getData() {
        return Arrays.stream(composites)
                .map(Composite::getData)
                .toArray(String[]::new);
    }
}
