package nullObject;

public class NullPattern {
    public static void main(String[] args) {
        AbstractCustomer cu1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer cu2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer cu3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer cu4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");
        System.out.println("=========");
        System.out.println(cu1.getName());
        System.out.println(cu2.getName());
        System.out.println(cu3.getName());
        System.out.println(cu4.getName());
    }
}
