public class River extends Location{

    Obstacle[] obstacles = new Obstacle[3];

    public River(Player player) {
        super(player);
        setName("River");
        Obstacle.getRandomObstacle(obstacles);
    }

    @Override
    public boolean onLocation(ListOfListObjects listOfListObjects) {
        Obstacle.printObstacles(getName(), obstacles);
        return false;
    }
}
