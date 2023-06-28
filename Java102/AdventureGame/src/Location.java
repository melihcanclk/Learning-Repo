import java.util.Random;
import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;

    private final Obstacle[] obstacles;

    protected Scanner sc = new Scanner(System.in);

    public Location(Player player) {
        this.player = player;
        Random random = new Random();
        int maxNumberOfObstacles = 3;

        maxNumberOfObstacles = random.nextInt(maxNumberOfObstacles) + 1;
        obstacles = new Obstacle[maxNumberOfObstacles];

        Obstacle.getRandomObstacle(obstacles);
    }

    public boolean onLocation(ListOfListObjects listOfListObjects) {
        Obstacle.printObstacles(getName(), obstacles);
        return true;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }
}
