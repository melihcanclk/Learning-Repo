package command;

public class Stock {
    private final String name = "ABC";
    private int quantity = 10;

    public void buy() {
        quantity++;
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        quantity--;
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}
