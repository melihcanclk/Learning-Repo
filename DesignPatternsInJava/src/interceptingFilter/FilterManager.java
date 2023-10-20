package interceptingFilter;

public class FilterManager {
    private final FilterChain filterChain;

    public FilterManager(){
        filterChain = new FilterChain();
    }
    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request){
        filterChain.executeFilter(request);
    }
}
