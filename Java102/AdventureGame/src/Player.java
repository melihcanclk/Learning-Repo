import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    private String name;

    private Inventory inventory;

    GameChar gameChar;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectCharacter() {
        List<GameChar> gameCharList = new ArrayList<>();
        gameCharList.add(new Samurai());
        gameCharList.add(new Archer());
        gameCharList.add(new Knight());

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
            case 1 -> gameChar = new Samurai();
            case 2 -> gameChar = new Archer();
            case 3 -> gameChar = new Knight();
            default -> exit(0);
        }

        System.out.println(gameChar.getType().name() + " is selected!");

    }
}
