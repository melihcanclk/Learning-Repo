package builder;

public abstract class ColdDrink extends PrintedItem{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();

}
