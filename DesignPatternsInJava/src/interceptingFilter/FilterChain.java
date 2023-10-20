package interceptingFilter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private final List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void executeFilter(String request) {
        for (Filter filter : filters) {
            filter.execute(request);
        }
    }
}
