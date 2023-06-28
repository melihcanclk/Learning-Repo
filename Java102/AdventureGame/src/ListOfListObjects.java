import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfListObjects {
    private final List<GameChar> gameCharListedObjects = new ArrayList<>();
    private final List<Location> locationListedObjects = new ArrayList<>();
    private final List<Weapon> weaponListedObjects = new ArrayList<>();
    private final List<Armor> armorListedObjects = new ArrayList<>();

    public ListOfListObjects() {
        gameCharListedObjects.addAll(Arrays.asList(new Knight(), new Samurai(), new Archer()));
        locationListedObjects.addAll(Arrays.asList(
                new SafeHouse(null),
                new ToolStore(null),
                new Forest(null),
                new Cave(null),
                new River(null)));
        weaponListedObjects.addAll(Arrays.asList(new Gun(), new Rifle(), new Sword()));
        armorListedObjects.addAll(Arrays.asList(new LightArmor(), new MediumArmor(), new HeavyArmor()));
    }

    public List<GameChar> getGameCharListedObjects() {
        return gameCharListedObjects;
    }

    public List<Location> getLocationListedObjects() {
        return locationListedObjects;
    }

    public List<Weapon> getWeaponListedObjects() {
        return weaponListedObjects;
    }

    public List<Armor> getArmorListedObjects() {
        return armorListedObjects;
    }
}
