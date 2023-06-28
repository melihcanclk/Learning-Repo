import java.util.Arrays;
import java.util.Objects;
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
        System.out.println("Welcome to " + this.getName());
        if(Arrays.stream(obstacles).allMatch(Objects::isNull)){
            System.out.println("There is no obstacle here.");
            return true;
        }else{
            Obstacle.printObstacles( obstacles);
            String ch = "y";
            do{
                System.out.println("Be careful, its so dangerous to be here. Do you wanna fight(y/n)?");
                ch = sc.next();
                ch = ch.toLowerCase();
                if(ch.equals("y")){
                    // fight
                    return fight();
                }else if(ch.equals("n")){
                    System.out.println("You selected to run away, you coward!");
                    return true;
                }else{
                    System.out.println("Wrong input, try again!");
                }
            }while (true);
        }
    }

    private boolean fight() {
        System.out.println("=================================================");
        System.out.println("Player Stats:");
        Player.printPlayerInfo(getPlayer());
        System.out.println("Obstacles Stats");
        Obstacle.printObstacles(obstacles);
        System.out.println("=================================================");
        int playerDamage = 0;
        if(getPlayer().getInventory().getWeapon() != null){
            playerDamage = getPlayer().getGameChar().getDamage() + getPlayer().getInventory().getWeapon().getDamage();
        }else{
            playerDamage = getPlayer().getGameChar().getDamage();
        }
        int playerBlock = 0;
        if(getPlayer().getInventory().getArmor() != null){
            playerBlock = getPlayer().getInventory().getArmor().getDefence();
        }
        int playerHealth = getPlayer().getGameChar().getHealth();

        for(int i = 0; i < obstacles.length; i++){
            System.out.println("You're going to fight with " + obstacles[i].getType().name() + " now.");
            int obstacleDamage = obstacles[i].getDamage();
            int obstacleHealth = obstacles[i].getHealth();

            while(playerHealth > 0 || obstacleHealth >0){
                obstacleHealth -= playerDamage;
                System.out.println(obstacles[i].getType().name() + " obstacle's health is " + obstacleHealth);

                if(obstacleHealth <= 0){
                    System.out.println("You killed " + obstacles[i].getType().name());
                    obstacles[i] = null;
                    getPlayer().getGameChar().setHealth(playerHealth);
                    break;
                }

                if(playerBlock != 0){
                    if(obstacleDamage > playerBlock){
                        playerHealth -= (obstacleDamage - playerBlock);
                        System.out.println(getPlayer().getName() + " blocked " + (obstacleDamage - playerBlock) + " with your block.");
                        playerBlock = 0;
                        getPlayer().getInventory().setArmor(null);
                    }else{
                        playerBlock -= obstacleDamage;
                        System.out.println(getPlayer().getName() + " blocked " + obstacleDamage + " with your block, your block is " + playerBlock + " now.");
                        getPlayer().getInventory().getArmor().setDefence(playerBlock);
                    }
                }else{
                    playerHealth -= obstacleDamage;
                }

                if(playerHealth <= 0){
                    System.out.println("You're dead!");
                    return false;
                }

                System.out.println(getPlayer().getName() + " 's health is " + playerHealth);
                System.out.println(obstacles[i].getType().name() + " obstacle's health is " + obstacleHealth);
            }
        }
        System.out.println("You survived!");
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
