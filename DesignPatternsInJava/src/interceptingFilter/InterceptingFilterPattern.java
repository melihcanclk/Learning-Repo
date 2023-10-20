package interceptingFilter;

public class InterceptingFilterPattern {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager();
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        filterManager.setFilter(new TargetFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }
}
