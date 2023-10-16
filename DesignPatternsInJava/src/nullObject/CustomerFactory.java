package nullObject;

public class CustomerFactory {

    private static final AbstractCustomer[] customers = {
            new CustomerImpl("Rob"),
            new CustomerImpl("Joe"),
            new CustomerImpl("Julie"),
            new NullCustomer()
    };
    // This method created 3 objects of CustomerImpl and 1 object of NullCustomer
    public static AbstractCustomer getCustomer(String name) {
        for (AbstractCustomer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return customers[3];
    }
}
