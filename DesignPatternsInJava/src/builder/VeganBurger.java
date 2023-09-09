package builder;

public class VeganBurger extends Burger{
    @Override
    public String name() {
        return "Vegan Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
