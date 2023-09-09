package builder;

/**
 * We have considered a business case of fast-food restaurant where a typical meal could be a burger and a cold drink.
 * Burger could be either a Veg Burger or Chicken Burger and will be packed by a wrapper.
 * Cold drink could be either a coke or pepsi and will be packed in a bottle.
 * We are going to create an Item interface representing food items such as burgers and cold drinks and concrete classes
 * implementing the Item interface and a Packing interface representing packaging of food items and concrete classes
 * implementing the Packing interface as burger would be packed in wrapper and cold drink would be packed as bottle.
 * https://www.tutorialspoint.com/design_pattern/builder_pattern.htm
 */
public class BuilderMain {
    public static void main(String[] args) {
        MenuBuilder mealBuilder = new MenuBuilder();

        Meal vegMeal = mealBuilder.prepareVeganMenu();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVeganMenu();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
