package builder;

public abstract class Burger extends PrintedItem{
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();


}
