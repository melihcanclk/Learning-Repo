
public class Cave extends Location {
    Obstacle[] obstacles = new Obstacle[2];

    public Cave(Player player) {
        super(player);
        setName("Cave");
        Obstacle.getRandomObstacle(obstacles);
    }

    @Override
    public boolean onLocation(ListOfListObjects listOfListObjects) {
        Obstacle.printObstacles(getName(), obstacles);
        return false;
    }
}
