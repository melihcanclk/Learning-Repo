import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionOfListObjects {
    private final List<GameChar> gameCharListedObjects = new ArrayList<>();
    private final List<Location> locationListedObjects = new ArrayList<>();
    private final List<Weapon> weaponListedObjects = new ArrayList<>();
    private final List<Armor> armorListedObjects = new ArrayList<>();

    public CollectionOfListObjects() {
        addToListedObjects(gameCharListedObjects, new Knight(), new Samurai(), new Archer());
        addToListedObjects(locationListedObjects, new SafeHouse(null),
                new ToolStore(null),
                new Forest(null),
                new Cave(null),
                new River(null));
        addToListedObjects(weaponListedObjects, new Gun(), new Rifle(), new Sword());
        addToListedObjects(armorListedObjects, new LightArmor(), new MediumArmor(), new HeavyArmor());
    }

    @SafeVarargs
    private <T> void addToListedObjects(List<T> list, T... objects) {
        list.addAll(Arrays.asList(objects));
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
