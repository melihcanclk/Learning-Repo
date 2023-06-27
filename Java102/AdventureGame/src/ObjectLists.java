import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class  ObjectLists<T> {
    private final List<T> list = new ArrayList<>();

    public List<T> getList(){
        return list;
    }
    @SafeVarargs
    public final void addToList(T... value){
        list.addAll(Arrays.asList(value));
    }
}
