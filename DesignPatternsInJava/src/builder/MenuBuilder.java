package builder;

public class MenuBuilder {

    public Meal prepareVeganMenu(){
        Meal meal = new Meal();
        meal.addItem(new VeganBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVeganMenu() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
