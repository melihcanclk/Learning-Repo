import java.util.Scanner;

public class Game {
    private static final Scanner sc = new Scanner(System.in);

    private static void start() {

        CollectionOfListObjects collectionOfListObjects = new CollectionOfListObjects();

        System.out.println("Welcome to our text-based Adventure Game.");
        System.out.print("Please enter your nickname:");
        String name = sc.next();

        Player player = new Player(name);
        System.out.println(player.getName() + " Welcome!");
        player.selectCharacter(collectionOfListObjects.getGameCharListedObjects());
        while (player.selectLocation(collectionOfListObjects.getLocationListedObjects())) {
            if (!player.getLocation().onLocation(collectionOfListObjects))
                break;
        }
    }

    public static void main(String[] args) {
        Game.start();
    }
}