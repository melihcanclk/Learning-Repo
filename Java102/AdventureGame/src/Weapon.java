import java.util.ArrayList;
import java.util.List;

enum WeaponType{
    GUN,
    SWORD,
    RIFLE
}
public class Weapon {
    private WeaponType weaponType;
    private int damage;
    private int money;

    private static final List<Weapon> weaponList = new ArrayList<>();
    static {
        weaponList.add(new Weapon(WeaponType.GUN, 2, 25));
        weaponList.add(new Weapon(WeaponType.SWORD, 3, 35));
        weaponList.add(new Weapon(WeaponType.RIFLE, 7, 45));
    }

    public Weapon(WeaponType weaponType, int damage, int money) {
        this.weaponType = weaponType;
        this.damage = damage;
        this.money = money;
    }

    public static List<Weapon> getWeaponList(){
        return weaponList;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
