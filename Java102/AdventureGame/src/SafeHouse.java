public class SafeHouse extends Location {

    public SafeHouse(Player player) {
        super(player);
        setName("Safe House");
        setObstaclesNull();
    }

    @Override
    public boolean onLocation(CollectionOfListObjects collectionOfListObjects) {
        System.out.println("Welcome to " + this.getName());
        getPlayer().getGameChar().getDefaulthealth();
        System.out.println("Your HP is " + getPlayer().getGameChar().getHealth() + " now");

        return true;
    }
}
