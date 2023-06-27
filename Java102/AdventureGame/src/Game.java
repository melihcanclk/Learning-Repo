import java.util.Scanner;

public class Game {
    private static final Scanner sc = new Scanner(System.in);

    private static void start() {
        ObjectLists<GameChar> gameCharObjectLists = new ObjectLists<>();
        ObjectLists<Location> locationObjectLists = new ObjectLists<>();
        ObjectLists<Weapon> weaponObjectLists = new ObjectLists<>();

        gameCharObjectLists.addToList(new Knight(), new Samurai(), new Archer());
        locationObjectLists.addToList(new SafeHouse(null), new ToolStore(null));
        weaponObjectLists.addToList(new Gun(), new Rifle(), new Sword());

        System.out.println("Oyunumuza hos geldiniz.");
        System.out.print("Lutfen isminizi giriniz:");
        String name = sc.next();

        Player player = new Player(name);
        System.out.println(player.getName() + " hosgeldin!");
        player.selectCharacter(gameCharObjectLists.getList());
        while (player.selectLocation(locationObjectLists.getList())) {
            if (!player.getLocation().onLocation(weaponObjectLists))
                break;
        }
    }

    public static void main(String[] args) {
        Game.start();
    }
}