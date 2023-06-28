import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.System.exit;

enum PlayerType {
    SAMURAI,
    ARCHER,
    KNIGHT,
    ZOMBIE,
    VAMPIRE,
    BEAR
}

public class Player {

    private final String name;


    private Inventory inventory;

    private static GameChar gameChar;

    private Location location;

    public GameChar getGameChar() {
        return gameChar;
    }

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public static void printPlayerInfo(Player player){
        System.out.println("=======================================================");
        System.out.println("Name:" + player.getName());
        System.out.println("Player Type:" + player.getGameChar().getType().name());
        System.out.println("Damage:" + player.getGameChar().getDamage());
        System.out.println("Health:" + player.getGameChar().getHealth());
        System.out.println("Money:" + player.getGameChar().getMoney());
        Weapon weapon = player.getInventory().getWeapon();
        Armor armor = player.getInventory().getArmor();
        if(weapon != null){
            System.out.println("Weapon: " + weapon.getWeaponType().name() +
                    " - Damage: " + weapon.getDamage() +
                    " - Price: " + weapon.getPrice());

        }else{
            System.out.println("Weapon Not Found");
        }

        if(armor != null){
            System.out.println("Armor: " + armor.getType().name() +
                    " - Defence: " + armor.getDefence() +
                    " - Price: " + armor.getPrice());
        }else{
            System.out.println("Armor Not Found");
        }
        System.out.println("=======================================================");

    }

    public void selectCharacter(List<GameChar> gameCharList) {
        for (int i = 0; i < gameCharList.size(); i++) {
            System.out.println(i + 1 + ". " + gameCharList.get(i).getType()
                    + " - Damage: " + gameCharList.get(i).getDamage()
                    + " - Health: " + gameCharList.get(i).getHealth()
                    + " - Money: " + gameCharList.get(i).getMoney());
        }

        System.out.println("4. Quit From Game");
        System.out.println("Lutfen karakterinizi seciniz:");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1 -> Player.gameChar = new Knight();
            case 2 -> Player.gameChar = new Samurai();
            case 3 -> Player.gameChar = new Archer();
            default -> exit(0);
        }

        System.out.println(gameChar.getType().name() + " is selected!");

    }

    private boolean controlGameEnd(List<Location> locationList){
        // if all the obstacles are killed, then end the game
        Stream<Boolean> booleanStream = locationList.stream().map((location) ->
                Arrays.stream(location.getObstacles()).allMatch(Objects::isNull)
        );
        boolean isAllPassed = booleanStream.allMatch((val) -> val);
        if(isAllPassed){
            System.out.println("You killed all obstacles, Congratzzz!!!");
            return true;
        }
        return false;
    }

    public boolean selectLocation(List<Location> locationList) {
       if(controlGameEnd(locationList))
           return false;

        printPlayerInfo(this);
        int selectedLocation = 1;
        do{
            int i = 0;
            for (; i < locationList.size(); i++) {
                System.out.println((i + 1) + ". " + locationList.get(i).getName());
            }
            System.out.println((i + 1) + ". Quit");
            System.out.println("Please select your location");
            Scanner sc = new Scanner(System.in);
            selectedLocation = sc.nextInt();
            if(selectedLocation == (i + 1)){
                return false;
            }
        }while (selectedLocation < 1 || selectedLocation > locationList.size());

        selectedLocation -= 1;

        location = locationList.get(selectedLocation);
        location.setPlayer(this);

        System.out.println(location.getName() + " is selected!");
        return true;
    }

    public Location getLocation() {
        return location;
    }

}
