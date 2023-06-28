public class Forest extends Location{

    private Obstacle[] obstacle = new Obstacle[1];
    public Forest(Player player) {
        super(player);
        setName("Forest");
        Obstacle.getRandomObstacle(obstacle);
    }

    @Override
    public boolean onLocation(ListOfListObjects listOfListObjects) {
        Obstacle.printObstacles(getName(), obstacle);
        return false;
    }
}
