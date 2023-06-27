enum WeaponType{
    GUN,
    SWORD,
    RIFLE
}
public abstract class Weapon {
    private WeaponType weaponType;
    private int damage;
    private int price;

    public Weapon(WeaponType weaponType, int damage, int money) {
        this.weaponType = weaponType;
        this.damage = damage;
        this.price = money;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
