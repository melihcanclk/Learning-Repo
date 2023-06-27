enum ArmorType{
    LIGHT,
    MEDIUM,
    HEAVY
}

public abstract class Armor {
    private ArmorType type;
    private int defence;
    private int price;

    public Armor(ArmorType type, int defence, int price) {
        this.type = type;
        this.defence = defence;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public ArmorType getType() {
        return type;
    }

    public void setType(ArmorType type) {
        this.type = type;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
