
public abstract class GameChar {
    private int damage;
    private int health;
    private int money;
    boolean isObstacle;
    private PlayerType type;

    public GameChar(int damage, int health, int money, PlayerType type, boolean isObstacle) {
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.type = type;
        this.isObstacle = isObstacle;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }
}
