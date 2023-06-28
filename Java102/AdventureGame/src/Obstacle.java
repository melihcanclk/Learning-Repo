import java.util.Random;

public abstract class Obstacle extends GameChar{

    public Obstacle(int damage, int health, int money, PlayerType type, boolean isObstacle) {
        super(damage, health, money, type, isObstacle);
    }

    protected static void getRandomObstacle(Obstacle[] obstacles){
        Random random = new Random();
        for(int i = 0; i < obstacles.length; i++){
            int randomIndex = random.nextInt(3);
            switch (randomIndex){
                case 0:
                    obstacles[i] = new Bear();
                    break;
                case 1:
                    obstacles[i] = new Zombie();
                    break;
                case 2:
                    obstacles[i] = new Vampire();
                    break;
            }
        }
    }

    public static void printObstacles(Obstacle[] obstacles){
        System.out.println("Obstacles that you should fight with are:");
        int i = 1;
        for (Obstacle obs : obstacles) {
            if(obs != null){
                System.out.println(i +
                        "-> Name: " + obs.getType() +
                        " - Health: " + obs.getHealth() +
                        " - Damage: " + obs.getDamage());
                i++;
            }

        }
    }
}
