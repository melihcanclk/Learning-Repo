import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;

    protected Scanner sc = new Scanner(System.in);

    public Location(Player player) {
        this.player = player;
    }

    public abstract boolean onLocation(ObjectLists<Weapon> objectLists);

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
}
