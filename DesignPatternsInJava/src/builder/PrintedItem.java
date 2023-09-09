package builder;

public abstract class PrintedItem implements Item{
    @Override
    public final String print() {
            return "Item: " +
                    name() +
                    ", Packing: " +
                    packing().pack() +
                    ", Price: " +
                    price() +
                    "\n";
    }
}
