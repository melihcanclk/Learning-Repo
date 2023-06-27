import java.util.Scanner;

public class Game {
    private static final Scanner sc = new Scanner(System.in);

    private static void start() {

        ListOfListObjects listOfListObjects = new ListOfListObjects();

        System.out.println("Oyunumuza hos geldiniz.");
        System.out.print("Lutfen isminizi giriniz:");
        String name = sc.next();

        Player player = new Player(name);
        System.out.println(player.getName() + " hosgeldin!");
        player.selectCharacter(listOfListObjects.getGameCharListedObjects());
        while (player.selectLocation(listOfListObjects.getLocationListedObjects())) {
            if (!player.getLocation().onLocation(listOfListObjects))
                break;
        }
    }

    public static void main(String[] args) {
        Game.start();
    }
}